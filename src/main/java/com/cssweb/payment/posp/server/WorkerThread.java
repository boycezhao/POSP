package com.cssweb.payment.posp.server;


import com.cssweb.payment.posp.business.BusiGetBalance;
import com.cssweb.payment.posp.business.BusiTestNetwork;
import com.cssweb.payment.posp.client.POSPClient;
import com.cssweb.payment.posp.network.CustomMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WorkerThread implements Runnable {
	private static final Logger logger =  LogManager.getLogger(WorkerThread.class.getName());
	private CustomMessage request;


    private BusiTestNetwork testNetwork = new BusiTestNetwork();
    private BusiGetBalance getBalance = new BusiGetBalance();
	
    private POSPClient client;

	public WorkerThread(CustomMessage req, POSPClient client)
	{

        this.request = req;
        this.client = client;
	}



	public void run() {
        //CustomMessage response = null;

        // 解析消息内容
        if (!request.decode())
        {
            System.out.println("decodeMsgContent error");
        }

        String msgType = new String(request.getMsgType().getMsgType());

        logger.info("消息类型 = " + msgType);

        if (msgType.equals("0820"))
        {
            testNetwork.process(request);
        }

        if (msgType == "0200")
        {
            getBalance.process(request);
        }


        //req.getChannelHandlerContext().writeAndFlush(response);
        client.sendResponse();
	}
}
