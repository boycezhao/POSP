package com.cssweb.payment.posp.network;

import com.cssweb.payment.posp.*;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenhf on 14-1-4.
 */
public class CustomMessage {
    private static final Logger logger = LogManager
            .getLogger(CustomMessage.class.getName());



    private MsgHeader msgHeader;
    private MessageType msgType;
    private BitFieldMap bitFieldMap;
    private FieldData fieldData;
    private byte[] msgContent; // 包含MessageType, BitFieldMap, fieldData
    private int msgContentSize;

    public int getMsgContentSize() {
        return msgContentSize;
    }

    public void setMsgContentSize(int msgContentSize) {
        this.msgContentSize = msgContentSize;
    }

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


    public MessageType getMsgType()
    {
        return msgType;
    }
    public void setMsgType(MessageType msgType)
    {
        this.msgType = msgType;
    }


    public FieldData getFieldData()
    {
        return fieldData;
    }
    /**
     * 返回添加的域的字节数组
     * @return
     */
    public void setFieldData(FieldData fieldData)
    {
        this.fieldData = fieldData;
    }

    public BitFieldMap getBitFieldMap()
    {
        return bitFieldMap;
    }
    public void setBitFieldMap(BitFieldMap bitFieldMap)
    {
        this.bitFieldMap = bitFieldMap;
    }





    public boolean decodeMsgContent()
    {
        int srcPos = 0;

        // 读消息类型
        byte[] msgTypeByteArray = new byte[MessageType.MSG_TYPE_SIZE];
        System.arraycopy(msgContent, srcPos, msgTypeByteArray, 0, MessageType.MSG_TYPE_SIZE);
        msgType.setMsgType(new String(msgTypeByteArray));
        srcPos += MessageType.MSG_TYPE_SIZE;

        // 读主位图
        byte[] mainBitFieldMapByteArray = new byte[BitFieldMap.BIT_FIELD_MAP_SIZE];
        System.arraycopy(msgContent, srcPos, mainBitFieldMapByteArray, 0, BitFieldMap.BIT_FIELD_MAP_SIZE);
        srcPos += BitFieldMap.BIT_FIELD_MAP_SIZE;
        bitFieldMap.setMainBitFieldMap(mainBitFieldMapByteArray);

        // 把主位图第一个字节转成二进制数组
        byte[] firstByteArray = BitUtil.byteToBinaryArray(mainBitFieldMapByteArray[0]);

        if (firstByteArray[0] == 1)
        {
            byte[] extBitFieldMapByteArray = new byte[BitFieldMap.BIT_FIELD_MAP_SIZE];
            System.arraycopy(msgContent, srcPos, extBitFieldMapByteArray, 0, BitFieldMap.BIT_FIELD_MAP_SIZE);
            srcPos += BitFieldMap.BIT_FIELD_MAP_SIZE;
            bitFieldMap.setExtBitFieldMap(extBitFieldMapByteArray);
        }

        // 解析域数据
        char[] array = bitFieldMap.getArray();
        int fieldNo = 0;
        for (int i=0; i<array.length; i++)
        {
            fieldNo = i + 1;

            if (array[i] == '1')
            {
                Field field = new Field();
                field.setFieldNo(fieldNo);

                fields.put(fieldNo, field);


            }
        }

        return true;
    }

    public int getTotalLen()
    {
        return 0;
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

    public boolean decode(CustomMessage customMessage)
    {

        BitFieldMap bitFieldMap = customMessage.getBitFieldMap();

        char[] array = bitFieldMap.getArray();
        byte[] fieldData = customMessage.getFieldData();
        int srcPos = 0;
        byte[] data = null;
        int fieldLen = 0;
        for (int i=0; i<array.length; i++)
        {
            if (array[i] != '1') {
                continue;
            }

            switch (i)
            {
                case 7:
                    field7 = new Field7();
                    fieldLen = field7.getFieldLength();
                    data = new byte[fieldLen];
                    break;

                case 11:
                    field11 = new Field11();
                    fieldLen = field11.getFieldLength();
                    data = new byte[fieldLen];
                    break;
            }

            System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
            srcPos += fieldLen;
        }




        byte[] f7data = new byte[field7.getFieldLength()];

        field7.setFieldValue(f7data);
        srcPos += f7data.length;

        byte[] f11data = new byte[field11.getFieldLength()];
        System.arraycopy(fieldData, srcPos, f11data, 0, f11data.length);
        field11.setFieldValue(f11data);
        srcPos += f11data.length;


        return true;
    }
}
