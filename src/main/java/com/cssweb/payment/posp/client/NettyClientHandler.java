/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.cssweb.payment.posp.client;

import com.cssweb.payment.posp.network.CustomMessage;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Handler for a client-side channel.  This handler maintains stateful
 * information which is specific to a certain channel using member variables.
 * Therefore, an instance of this handler can cover only one channel.  You have
 * to create a new handler instance whenever you create a new channel and insert
 * this handler to avoid a race condition.
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<CustomMessage> {
    private static final Logger logger = LogManager.getLogger(NettyClientHandler.class.getName());


    private ChannelHandlerContext ctx;

    final BlockingQueue<CustomMessage> answer = new LinkedBlockingQueue<CustomMessage>();

    public void sendRequest(CustomMessage customMessage) {

        ChannelFuture future = null;

        future = ctx.write(customMessage);

        future.addListener(numberSender);

        ctx.flush();
    }

    public CustomMessage recvResponse() {
        boolean interrupted = false;
        try {
            for (;;) {
                try {
                    System.out.println("recvResponse");
                    return answer.take();
                } catch (InterruptedException ignore) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                // Thread.currentThread().interrupt();
            }
        }
    }

    private final ChannelFutureListener numberSender = new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
                System.out.println("send is success....");
            } else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        }
    };



    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;


    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CustomMessage customMessage) throws Exception {

        System.out.println("recv msg");

        answer.offer(customMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
