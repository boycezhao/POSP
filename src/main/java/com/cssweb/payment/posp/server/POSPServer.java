
package com.cssweb.payment.posp.server;


import com.cssweb.payment.posp.client.POSPClient;
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
    private static final Logger logger = LogManager.getLogger(POSPServer.class.getName());

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();


    private final int port;
    private POSPClient client;

    public POSPServer(int port, POSPClient client) {
        this.port = port;
        this.client = client;
    }

    @Override
    public void run() {

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .option(ChannelOption.SO_BACKLOG, 8192)
             .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new NettyServerInitializer(client));

            b.bind(port).sync().channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }


}
