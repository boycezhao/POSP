package com.cssweb.payment.posp.network;

import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by chenhf on 14-1-4.
 */
public class CustomMessage {
    private static final Logger logger = LogManager.getLogger(CustomMessage.class.getName());
    public static final int PKG_HEADER_SIZE = 4;

    private byte[] pkgHeader = new byte[PKG_HEADER_SIZE];
    private int pkgContentSize;

    private byte[] pkgContent; // MsgHeader, MessageType, BitFieldMap, FieldData
    private MsgHeader msgHeader;
    private MessageType msgType;
    private BitFieldMap bitFieldMap;
    private FieldData fieldData;


    private AsynchronousSocketChannel channel;
    private ChannelHandlerContext channelHandlerContext;


	public ChannelHandlerContext getChannelHandlerContext() {
		return channelHandlerContext;
	}
	public void setChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
		this.channelHandlerContext = channelHandlerContext;
	}

	public AsynchronousSocketChannel getChannel() {
		return channel;
	}
	public void setChannel(AsynchronousSocketChannel channel) {
		this.channel = channel;
	}





    public byte[] getPkgHeader() {
        return pkgHeader;
    }

    public void setPkgHeader(byte[] pkgHeader) {
        this.pkgHeader = pkgHeader;
    }

    public void setPkgContent(byte[] pkgContent) {
        this.pkgContent = pkgContent;
    }
    public byte[] getPkgContent() {
        return pkgContent;
    }

    public int getPkgContentSize() {
        return pkgContentSize;
    }
    public void setPkgContentSize(int pkgContentSize) {
        this.pkgContentSize = pkgContentSize;
    }


    public MsgHeader getMsgHeader() {
        return msgHeader;
    }
    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    public MessageType getMsgType()
    {
        return msgType;
    }
    public void setMsgType(MessageType msgType)
    {
        this.msgType = msgType;
    }

    public BitFieldMap getBitFieldMap()
    {
        return bitFieldMap;
    }
    public void setBitFieldMap(BitFieldMap bitFieldMap)
    {
        this.bitFieldMap = bitFieldMap;
    }

    public FieldData getFieldData()
    {
        return fieldData;
    }
    public void setFieldData(FieldData fieldData)
    {
        this.fieldData = fieldData;
    }


     /**
     * 把
     * @return
     */
    public boolean encode()
    {
        int msgContentLen = MsgHeader.MSG_HEADER_SIZE + MessageType.MSG_TYPE_SIZE + bitFieldMap.getBitFieldMapLen() + fieldData.getFieldDataLen();

        pkgContent = new byte[msgContentLen];

        int destPos = 0;

        // 消息头
        System.arraycopy(msgHeader.getMsgHeader(), 0, pkgContent, destPos, msgHeader.getMsgHeaderLen());
        destPos += msgHeader.getMsgHeaderLen();

        // 消息类型
        System.arraycopy(msgType.getMsgType(), 0, pkgContent, destPos, msgType.getMsgTypeLen());
        destPos += msgType.getMsgTypeLen();

        // 位域映射
        System.arraycopy(bitFieldMap.getMainBitFieldMap(), 0, pkgContent, destPos, bitFieldMap.getMainBitFieldMapLen());
        destPos += bitFieldMap.getMainBitFieldMapLen();

        if (bitFieldMap.isExtBitFieldMap()) {
            System.arraycopy(bitFieldMap.getExtBitFieldMap(), 0, pkgContent, destPos, bitFieldMap.getExtBitFieldMapLen());
            destPos += bitFieldMap.getExtBitFieldMapLen();

        }

        // 域数据内容
        System.arraycopy(fieldData.getFieldData(), 0, pkgContent, destPos, fieldData.getFieldDataLen());

        pkgContentSize = pkgContent.length;

        pkgHeader = ByteArrayIntUtil.intToByteArrayH(pkgContentSize);

        return true;
    }

    public boolean decode()
    {
        int srcPos = 0;

        // 读消息头
        msgHeader = new MsgHeader();
        byte[] msgHeaderByteArray = new byte[MsgHeader.MSG_HEADER_SIZE];
        System.arraycopy(pkgContent, srcPos, msgHeaderByteArray, 0, MsgHeader.MSG_HEADER_SIZE);
        msgHeader.decode(msgHeaderByteArray);
        srcPos += MsgHeader.MSG_HEADER_SIZE;

        // 读消息类型
        msgType = new MessageType();
        byte[] msgTypeByteArray = new byte[MessageType.MSG_TYPE_SIZE];
        System.arraycopy(pkgContent, srcPos, msgTypeByteArray, 0, MessageType.MSG_TYPE_SIZE);
        msgType.setMsgType(msgTypeByteArray);
        srcPos += MessageType.MSG_TYPE_SIZE;
        logger.info("msgType = " + new String(msgType.getMsgType()));

        // 读主位图
        bitFieldMap = new BitFieldMap();
        byte[] mainBitFieldMapByteArray = new byte[BitFieldMap.BIT_FIELD_MAP_SIZE];
        System.arraycopy(pkgContent, srcPos, mainBitFieldMapByteArray, 0, BitFieldMap.BIT_FIELD_MAP_SIZE);
        srcPos += BitFieldMap.BIT_FIELD_MAP_SIZE;
        bitFieldMap.setMainBitFieldMap(mainBitFieldMapByteArray);

        // 读扩展位图
        if (bitFieldMap.isExtBitFieldMap())
        {
            byte[] extBitFieldMapByteArray = new byte[BitFieldMap.BIT_FIELD_MAP_SIZE];
            System.arraycopy(pkgContent, srcPos, extBitFieldMapByteArray, 0, BitFieldMap.BIT_FIELD_MAP_SIZE);
            srcPos += BitFieldMap.BIT_FIELD_MAP_SIZE;
            bitFieldMap.setExtBitFieldMap(extBitFieldMapByteArray);
        }

        byte[] array = bitFieldMap.getArray();
        logger.info("array = " + bitFieldMap.getArrayStr());


        // 解析域数据
        fieldData = new FieldData();
        byte[] data = new byte[msgHeader.getMsgContentSize() - MessageType.MSG_TYPE_SIZE - bitFieldMap.getBitFieldMapLen()];
        System.arraycopy(pkgContent, srcPos, data, 0, data.length);
        logger.info("fieldata = " + new String(data) + ", len=" + data.length);

        fieldData.decode(array, data);
        logger.info("fieldData = " + new String(fieldData.getFieldData()));

        return true;
    }


}
