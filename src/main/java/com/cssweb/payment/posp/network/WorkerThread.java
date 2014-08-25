package com.cssweb.payment.posp.network;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WorkerThread implements Runnable {
	private static final Logger logger =  LogManager.getLogger(WorkerThread.class.getName());
	private CustomMessage req;
	private String response;
	

	public WorkerThread(CustomMessage req)
	{
		this.req = req;
	}

    public void testNetwork()
    {

    }

	public void run() {
        CustomMessage response = null;

        // 解析消息内容
        if (!req.decodeMsgContent())
        {
            System.out.println("decodeMsgContent error");
        }

        String msgType = new String(req.getMsgType().getMsgType());

        if (msgType == "0820")
        {
            testNetwork();
        }


        req.getChannelHandlerContext().writeAndFlush(response);
	}
}
