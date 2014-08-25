package com.cssweb.payment.posp.network;

import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by chenhf on 14-1-4.
 */
public class CustomMessage {
    private static final Logger logger = LogManager
            .getLogger(CustomMessage.class.getName());

    private MsgHeader msgHeader;
    private byte[] msgContent;

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


    /*
    public void setMsgHeader(byte msgType, int functionNo, byte zip) {
        msgHeader.setZip(zip);
        msgHeader.setMsgType(msgType);
        msgHeader.setFunctionNo(functionNo);

        msgHeader.setMsgContentSize(msgContent.length);

        msgHeader.setCrc(0);
    }

    public void setMsgHeader(byte[] msgHeader) throws IOException {

        this.msgHeader.setMsgHeader(msgHeader);

        msgContent = new byte[this.msgHeader.getMsgContentSize()];
    }

    public byte[] getMsgHeader() throws IOException {
        return msgHeader.getMsgHeader();
    }

*/

    public void setMsgContent(byte[] msgContent) {
        this.msgContent = msgContent;
    }
    public byte[] getMsgContent() {
        return msgContent;
    }



    /*
    返回消息内容长度

    public int getMsgContentSize()
    {
        return msgHeader.getMsgContentSize();
    }*/
}
