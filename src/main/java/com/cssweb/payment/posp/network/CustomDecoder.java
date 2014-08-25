package com.cssweb.payment.posp.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;


public class CustomDecoder extends ByteToMessageDecoder {
	 private static final Logger logger =  LogManager.getLogger(
             CustomDecoder.class.getName());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
    	logger.info("decode");
        
    	// 判断消息头是否可读
        if (in.readableBytes() < MsgHeader.MSG_HEADER_SIZE) {
        	logger.info("消息头不完整");
            return;
        }
        in.markReaderIndex();
        
        // 读消息头
        byte[] bytes = new byte[MsgHeader.MSG_HEADER_SIZE];
        in.readBytes(bytes);


        MsgHeader msgHeader = new MsgHeader();


        try {
            msgHeader.decodeMsgHeader(bytes);
		} catch (IOException e) {
			logger.error("解析消息头异常：" + e);
		}

        // 等待只到消息内容接收完成
        if (in.readableBytes() < msgHeader.getMsgContentSize()) {
            in.resetReaderIndex();
            logger.info("消息内容不完整");
            return;
        }

        byte[] msgContent = new byte[msgHeader.getMsgContentSize()];
        in.readBytes(msgContent);



        CustomMessage customMessage = new CustomMessage();
        customMessage.setMsgHeader(msgHeader);
        customMessage.setMsgContent(msgContent);
        customMessage.setChannelHandlerContext(ctx);

        out.add(customMessage);
    }
}
