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
package com.cssweb.payment.posp.server;

import com.cssweb.payment.posp.business.WorkerThread;
import com.cssweb.payment.posp.business.WorkerThreadPool;
import com.cssweb.payment.posp.client.POSPClient;
import com.cssweb.payment.posp.network.CustomMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NettyServerHandler extends
		SimpleChannelInboundHandler<CustomMessage> {

    private static final Logger logger = LogManager.getLogger(NettyServerHandler.class.getName());

    private POSPClient client;


    public NettyServerHandler(POSPClient client)
    {
        this.client = client;
    }

    @Override
    public boolean acceptInboundMessage(java.lang.Object msg)
    {
        logger.info("========================================");
        return true;
    }

	@Override
	public void channelRead0(ChannelHandlerContext ctx, CustomMessage request)
			throws Exception {
		logger.info("channelRead0");

		request.setChannelHandlerContext(ctx);

		WorkerThread reqTask = new WorkerThread(request, client);
		WorkerThreadPool.getInstance().execute(reqTask);

		// ctx.writeAndFlush(request);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("channelInactive");
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.error("exceptionCaught", cause);
		ctx.close();
	}
}
