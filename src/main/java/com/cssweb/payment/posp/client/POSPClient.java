package com.cssweb.payment.posp.client;




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




    public void sendResponse()
    {

    }

/*
    public void testNetwork()
    {
        CustomMessage customMessage = new CustomMessage();
        List<Field> fields = new ArrayList<Field>();
        MsgHeader msgHeader = new MsgHeader();
        MessageType msgType = new MessageType();
        BitFieldMap bitFieldMap = new BitFieldMap();
        FieldData fieldData = new FieldData();

        // 设置域值
        Field7 f7 = new Field7();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        String tranTime = sdf.format(now);
        f7.setFieldValue(tranTime);

        Field11 f11 = new Field11();
        String traceNo = "";
        Random random = new Random();
        for (int i=0; i<6; i++) {
            traceNo += random.nextInt(10);
        }
        f11.setFieldValue(traceNo);

        Field33 f33 = new Field33();
        f33.setFieldValue("111111");

        Field39 f39 = new Field39();
        f39.setFieldValue("00");

        Field70 f70 = new Field70();
        f70.setFieldValue("301"); // 线路测试


        fields.add(f7);
        fields.add(f11);
        fields.add(f33);
        fields.add(f39);
        fields.add(f70);
        // 设置域值结束


        // 开始处理消息类型
        msgType.setMsgType("0820");
        customMessage.setMsgType(msgType);
        logger.info("msgType = " + new String(msgType.getMsgType()));
        // 结束处理消息类型



        // 设置位图
        bitFieldMap.setFields(fields);
        customMessage.setBitFieldMap(bitFieldMap);

        logger.info("array = " + bitFieldMap.getArrayStr());



        try {
            // 设置域值
            fieldData.encode(fields);
            customMessage.setFieldData(fieldData);
            logger.info("fieldData = " + new String(fieldData.getFieldData()));

            // 设置消息头
            int totalLen = MsgHeader.MSG_HEADER_SIZE + MessageType.MSG_TYPE_SIZE + bitFieldMap.getBitFieldMapLen() + fieldData.getFieldDataLen();
            logger.info("totalLen = " + totalLen);
            msgHeader.encodeMsgHeader(totalLen, "00010000", "00010000", (byte)0, "00000000", (byte)0, "00000");
            customMessage.setMsgHeader(msgHeader);

            // 消息编码,这一步非常重要，把msgType, bitFieldMap, fieldData合成msgContent
            customMessage.encode();


        } catch (IOException e) {
            e.printStackTrace();
        }



        handler.sendRequest(customMessage);

        CustomMessage response = handler.recvResponse();

        response.decode();

        FieldData resFieldData = response.getFieldData();
        Field7 resF7 = (Field7) resFieldData.getField(7);
        logger.info("resF7=" + new String(resF7.getFieldValue()));
    }

    */
}
