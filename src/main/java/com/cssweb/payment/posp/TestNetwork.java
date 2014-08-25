package com.cssweb.payment.posp;

import com.cssweb.payment.posp.network.CustomMessage;
import com.cssweb.payment.posp.network.MsgHeader;

/**
 * Created by chenhf on 2014/8/25.
 */
public class TestNetwork implements BusinessAction {

    private TestNetworkRequest request = new TestNetworkRequest();
    private TestNetworkResponse response;



    @Override
    public void process(CustomMessage req) {

        // 读取请求域的值
        request.decode(req);


        Field7 field7 = new Field7();
        Field11 field11 = new Field11();
        Field33 field33 = new Field33();
        Field39 field39 = new Field39();
        Field70 field70 = new Field70();

        MsgHeader msgHeader = new MsgHeader();
        MessageType msgType = new MessageType();
        BitFieldMap bitFieldMap = new BitFieldMap();

        response.setMsgHeader(msgHeader);
        response.setMessageType(msgType);
        response.setBitMainMap(bitFieldMap);
        response.setData();

        // 发送应答结果
        req.getChannelHandlerContext().writeAndFlush(response);

    }
}
