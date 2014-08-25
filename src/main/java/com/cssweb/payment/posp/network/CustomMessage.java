package com.cssweb.payment.posp.network;

import com.cssweb.payment.posp.BitFieldMap;
import com.cssweb.payment.posp.Field;
import com.cssweb.payment.posp.MessageType;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.HashMap;

/**
 * Created by chenhf on 14-1-4.
 */
public class CustomMessage {
    private static final Logger logger = LogManager
            .getLogger(CustomMessage.class.getName());

    private MsgHeader msgHeader;
    private byte[] msgContent; // 包含MessageType, BitFieldMap, FieldData

    private MessageType msgType;
    private BitFieldMap bitFieldMap;
    private HashMap<Integer, Field> fields = new HashMap<Integer, Field>();

    private AsynchronousSocketChannel channel;
    private ChannelHandlerContext channelHandlerContext;


    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }
// 只是为了测试aio demo
    //private ByteBuffer msgHeaderBuf = ByteBuffer.allocate(MsgHeader.MSG_HEADER_SIZE);


    


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

        char[] array = bitFieldMap.getArray();
        for (int i=0; i<array.length; i++)
        {
            if (array[i] == '1')
            {

            }
        }

        return true;
    }
}
