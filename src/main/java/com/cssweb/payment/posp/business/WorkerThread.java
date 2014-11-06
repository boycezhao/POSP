package com.cssweb.payment.posp.business;


import com.cssweb.payment.posp.client.POSPClient;
import com.cssweb.payment.posp.common.Field3;
import com.cssweb.payment.posp.common.Field70;
import com.cssweb.payment.posp.network.CustomMessage;
import com.cssweb.payment.posp.network.FieldData;
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
            logger.error("解码消息失败");
        }

        String msgType = new String(request.getMsgType().getMsgType());

        logger.info("消息类型 = " + msgType);



        if (msgType.equals("0200"))
        {
            FieldData reqFieldData = request.getFieldData();
            Field3 reqField3 = (Field3) reqFieldData.getField(3);
            String f3data = new String(reqField3.getData());

            if (f3data.equalsIgnoreCase("30x000"))
            {
                // 余额查询
                BusiGetBalance getBalance = new BusiGetBalance();
                response = getBalance.process(request);
                client.sendResponse(response);
            }
            else if(f3data.equalsIgnoreCase("00x000"))
            {
                // 消费
                BusiConsume consume = new BusiConsume();
                response = consume.process(request);
                client.sendResponse(response);
            }
            else if(f3data.equalsIgnoreCase("20x000"))
            {
                // 消费撤销
                BusiConsumeCancel consumeCancel = new BusiConsumeCancel();
                response = consumeCancel.process(request);
                //client.sendResponse(response);
            }
            else
            {

            }
        }
        else if(msgType.equals("0420"))
        {
            FieldData reqFieldData = request.getFieldData();
            Field3 reqField3 = (Field3) reqFieldData.getField(3);
            String f3data = new String(reqField3.getData());

            if (f3data.equalsIgnoreCase("00x000")) {

                // 冲正
                BusiConsumeReverse consumeReverse = new BusiConsumeReverse();
                response = consumeReverse.process(request);
                client.sendResponse(response);
            }
            else if (f3data.equalsIgnoreCase("20x000"))
            {
                // 消费冲正撤消
                BusiConsumeReverseCancel consumeReverseCancel = new BusiConsumeReverseCancel();
                response = consumeReverseCancel.process(request);
                //client.sendResponse(response);
            }
        }
        else if(msgType.equals("0220"))
        {
            // 退货
            BusiSalesReturn salesReturn = new BusiSalesReturn();
            response = salesReturn.process(request);
            //client.sendResponse(response);
        }
        else if(msgType.equals("0830"))
        {
            // POSP发起，响应来自SW/POSPClient的applyKey应答
            FieldData reqFieldData = request.getFieldData();
            Field70 field70 = (Field70) reqFieldData.getField(70);
            String f70data = new String(field70.getData());

            if (f70data.equalsIgnoreCase("101")) {
                BusiApplyKey applyKey = new BusiApplyKey();
                response = applyKey.process(request);
            }
        }
        else if(msgType.equals("0800"))
        {
            // 处理来自POSPClient的请求
            BusiResetKey resetKey = new BusiResetKey();
            response = resetKey.process(request);
            client.sendResponse(response);
        }
        else
        {

        }


	}
}
