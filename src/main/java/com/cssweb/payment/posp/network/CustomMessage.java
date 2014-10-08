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

    private MsgHeader msgHeader;
    private MessageType msgType;
    private BitFieldMap bitFieldMap;

    private FieldData fieldData;
    private byte[] msgContent; // 包含MessageType, BitFieldMap, fieldData
    private int msgContentSize;

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


    public MsgHeader getMsgHeader() {
        return msgHeader;
    }
    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }


    public void setMsgContent(byte[] msgContent) {
        this.msgContent = msgContent;
    }
    public byte[] getMsgContent() {
        return msgContent;
    }

    public int getMsgContentSize() {
        return msgContentSize;
    }
    public void setMsgContentSize(int msgContentSize) {
        this.msgContentSize = msgContentSize;
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
        int msgContentLen = MessageType.MSG_TYPE_SIZE + bitFieldMap.getBitFieldMapLen() + fieldData.getFieldDataLen();

        msgContent = new byte[msgContentLen];

        int destPos = 0;

        System.arraycopy(msgType.getMsgType(), 0, msgContent, destPos, msgType.getMsgTypeLen());
        destPos += msgType.getMsgTypeLen();

        System.arraycopy(bitFieldMap.getMainBitFieldMap(), 0, msgContent, destPos, bitFieldMap.getMainBitFieldMapLen());
        destPos += bitFieldMap.getMainBitFieldMapLen();

        if (bitFieldMap.isExtBitFieldMap()) {
            System.arraycopy(bitFieldMap.getExtBitFieldMap(), 0, msgContent, destPos, bitFieldMap.getExtBitFieldMapLen());
            destPos += bitFieldMap.getExtBitFieldMapLen();

        }

        System.arraycopy(fieldData.getFieldData(), 0, msgContent, destPos, fieldData.getFieldDataLen());

        msgContentSize = msgContent.length;

        return true;
    }

    public boolean decode()
    {
        int srcPos = 0;

        // 读消息类型
        msgType = new MessageType();
        byte[] msgTypeByteArray = new byte[MessageType.MSG_TYPE_SIZE];
        System.arraycopy(msgContent, srcPos, msgTypeByteArray, 0, MessageType.MSG_TYPE_SIZE);
        msgType.setMsgType(msgTypeByteArray);
        srcPos += MessageType.MSG_TYPE_SIZE;
        logger.info("msgType = " + new String(msgType.getMsgType()));

        // 读主位图
        bitFieldMap = new BitFieldMap();
        byte[] mainBitFieldMapByteArray = new byte[BitFieldMap.BIT_FIELD_MAP_SIZE];
        System.arraycopy(msgContent, srcPos, mainBitFieldMapByteArray, 0, BitFieldMap.BIT_FIELD_MAP_SIZE);
        srcPos += BitFieldMap.BIT_FIELD_MAP_SIZE;
        bitFieldMap.setMainBitFieldMap(mainBitFieldMapByteArray);

        // 读扩展位图
        if (bitFieldMap.isExtBitFieldMap())
        {
            byte[] extBitFieldMapByteArray = new byte[BitFieldMap.BIT_FIELD_MAP_SIZE];
            System.arraycopy(msgContent, srcPos, extBitFieldMapByteArray, 0, BitFieldMap.BIT_FIELD_MAP_SIZE);
            srcPos += BitFieldMap.BIT_FIELD_MAP_SIZE;
            bitFieldMap.setExtBitFieldMap(extBitFieldMapByteArray);
        }

        byte[] array = bitFieldMap.getArray();
        logger.info("array = " + bitFieldMap.getArrayStr());


        // 解析域数据
        fieldData = new FieldData();
        byte[] data = new byte[msgHeader.getMsgContentSize() - MessageType.MSG_TYPE_SIZE - bitFieldMap.getBitFieldMapLen()];
        System.arraycopy(msgContent, srcPos, data, 0, data.length);
        fieldData.decode(array, data);
        logger.info("fieldData = " + new String(fieldData.getFieldData()));

        return true;
    }


}
