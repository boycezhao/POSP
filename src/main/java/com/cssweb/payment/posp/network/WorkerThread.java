package com.cssweb.payment.posp.network;

import com.cssweb.payment.account.AccountService;
import com.cssweb.payment.account.AccountServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WorkerThread implements Runnable {
	private static final Logger logger =  LogManager.getLogger(WorkerThread.class.getName());
	
	private static final String FIELD_SEPERATOR = String.valueOf((char)0x01);
	
	private CustomMessage req;
	
	private String response;
	


	
	public WorkerThread(CustomMessage req)
	{
		
		this.req = req;
		
		
	}

	public void run() {
        CustomMessage response = null;

        if (req.getMsgHeader().getMsgType() == MessageType.LOGIN_REQ)
        {
            AccountService accountService = new AccountServiceImpl();

            response = accountService.login(req);
        }


        req.getChannelHandlerContext().writeAndFlush(response);


/*

		String request = new String(req.getMsgContent());
		logger.info("原始请求：" + request);
		
		
		request = request.replace(FIELD_SEPERATOR, "&");
		if (request.substring(request.length()-1).compareTo("&") == 0)
			request = request.substring(0, request.length()-1);
		logger.info("转换后请求：" + request);
		
		Map<String, String> mapRequest = Splitter.on('&').withKeyValueSeparator('=').split(request);
		

		

			response = "1" + FIELD_SEPERATOR + "2" + FIELD_SEPERATOR;
			response += "cssweb_errcode" + FIELD_SEPERATOR + "cssweb_errmsg" + FIELD_SEPERATOR;
			response +=  "1001" + FIELD_SEPERATOR + "服务未实现" + FIELD_SEPERATOR;
			

		
		
		
		sendResponse();
		return;
		*/

	}
	/*
	private void sendResponse()
	{

		
		CustomMessage res = new CustomMessage();
		res.setChannel(req.getChannel());


            res.setMsgContent(response.getBytes());


        res.setMsgHeader((byte)0, 0, (byte)0);

        req.getChannelHandlerContext().writeAndFlush(res);
*/
		/*
		//ByteBuffer pkgBody = ByteBuffer.wrap(response.getBytes());
		ByteBuffer pkgHeader = null;
		try
		{
			pkgHeader = ByteBuffer.wrap(res.getMsgHeader());
		}
		catch(IOException exp){
			logger.error("");
		}
		
		
		//res.getChannel().write(pkgHeader, res, writerPkgHeaderHandler);
		*/

	//}

}
