package com.cssweb.payment.posp.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomEncoder extends MessageToByteEncoder<CustomMessage> {
	 private static final Logger logger =  LogManager.getLogger(CustomEncoder.class.getName());
	 
    @Override
    protected void encode(ChannelHandlerContext ctx, CustomMessage customMessage, ByteBuf out) throws Exception {
    	// 发送消息头
    	out.writeBytes(customMessage.getPkgHeader());
       
    	// 发送消息内容
        out.writeBytes(customMessage.getPkgContent());
    }
}
