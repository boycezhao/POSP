package com.cssweb.payment.posp.business;


import com.cssweb.payment.posp.client.POSPClient;
import com.cssweb.payment.posp.network.CustomMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WorkerThread implements Runnable {
	private static final Logger logger =  LogManager.getLogger(WorkerThread.class.getName());

    private POSPClient client;
	private CustomMessage request;

	public WorkerThread(CustomMessage req, POSPClient client)
	{
        this.request = req;
        this.client = client;
	}



	public void run() {
        CustomMessage response = null;

        // 解析消息内容
        if (!request.decode())
        {
            logger.error("decodeMsgContent error");
        }

        String msgType = new String(request.getMsgType().getMsgType());

        logger.info("消息类型 = " + msgType);

        if (msgType.equals("0820"))
        {
            BusiEchoTest echo = new BusiEchoTest();
            response = echo.process(request);
            client.sendResponse(response);
        }

        if (msgType.equals("0200"))
        {
            logger.info("接收到余额查询请求");
            BusiGetBalance getBalance = new BusiGetBalance();
            response = getBalance.process(request);
            //client.sendResponse(response);
        }


	}
}
