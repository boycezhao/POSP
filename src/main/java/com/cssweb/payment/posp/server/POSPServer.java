
package com.cssweb.payment.posp.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class POSPServer implements Runnable{
    private static final Logger logger = LogManager
            .getLogger(POSPServer.class.getName());

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    ServerBootstrap b = new ServerBootstrap();

    private final int port;

    public POSPServer(int port) {
        this.port = port;
    }

    public void run() {

        try {

            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 8192)
                    .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new NettyServerInitializer());

            b.bind(port).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }


}
