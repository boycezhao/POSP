package com.cssweb.payment.posp.client;




import com.cssweb.payment.posp.network.CustomMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by chenhf on 2014/7/14.
 */

public class POSPClient implements Runnable{
    private static final Logger logger =  LogManager.getLogger(POSPClient.class.getName());

    private EventLoopGroup group = new NioEventLoopGroup();


    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private NettyClientHandler handler = null;

    private boolean connected = false;




    private static String unionServer;
    private static int port;




    public POSPClient(String unionServer, int port)
    {
        POSPClient.unionServer = unionServer;
        POSPClient.port = port;
    }
    // 中断重连
    // 超时重连

    public boolean connect()
    {


        try {
            logger.info("开始连接。。。");

            Bootstrap b = new Bootstrap();


            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new NettyClientInitializer());


            ChannelFuture future = b.connect(unionServer, port).sync();


             handler =  (NettyClientHandler) future.channel().pipeline().last();


            connected = true;

            // 阻塞， 等待连接中断
            future.channel().closeFuture().sync();

        } catch (Exception e) {
            logger.error("连接异常信息1：===============");

            e.printStackTrace();

            connected = false;
        } finally {
            logger.error("连接中断");

            executor.execute(new Runnable()
            {

                @Override
                public void run()
                {
                    try {

                        TimeUnit.SECONDS.sleep(5);

                        connect();

                    } catch (Exception e) {
                        logger.error("连接异常信息2：===============");
                        e.printStackTrace();
                    }
                }
            });


        }

        return connected;
    }

    @Override
    public void run()
    {
        connect();

        logger.error("线程函数结束");
    }

    public void close()
    {
        logger.info("payment client 关闭.....................................");


        group.shutdownGracefully();
    }


    /**
     * 发送应答消息
     * @param response
     */
    public void sendResponse(CustomMessage response)
    {
        handler.sendResponse(response);
    }



    public void applyKey() {
        TestApplyKey test = new TestApplyKey();
        CustomMessage request = test.getRequest();
        handler.sendRequest(request);
    }
}
