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
        int readBytes = in.readableBytes();
        if (readBytes < MsgHeader.MSG_HEADER_SIZE) {
        	logger.info("消息头不完整，已读字节数" + readBytes);
            return;
        }
        in.markReaderIndex();
        
        // 读消息头
        byte[] pkgHeader = new byte[CustomMessage.PKG_HEADER_SIZE];
        in.readBytes(pkgHeader);
        int pkgContentSize = ByteArrayIntUtil.byteArrayToIntH(pkgHeader);
        logger.info("消息内容大小" + pkgContentSize);


        // 等待只到消息内容接收完成
        readBytes = in.readableBytes();
        if (readBytes < pkgContentSize) {
            in.resetReaderIndex();
            logger.info("消息内容不完整");
            return;
        }

        byte[] pkgContent = new byte[pkgContentSize];
        in.readBytes(pkgContent);



        CustomMessage customMessage = new CustomMessage();
        customMessage.setPkgHeader(pkgHeader);
        customMessage.setPkgContent(pkgContent);
        customMessage.setChannelHandlerContext(ctx);

        out.add(customMessage);
    }
}
