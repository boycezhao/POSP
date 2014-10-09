package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.network.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by chenhf on 2014/8/25.
 */
public class BusiTestNetwork implements BusinessAction {
    private static final Logger logger = LogManager.getLogger(BusiTestNetwork.class.getName());

    @Override
    public CustomMessage process(CustomMessage request) {
        logger.info("process...");

        // 处理请求消息
        FieldData reqField = request.getFieldData();
        Field7 reqF7 = (Field7) reqField.getField(7);
        logger.info("reqF7=" + new String(reqF7.getFieldValue()));


        // 应答消息
        CustomMessage response = new CustomMessage();


        MsgHeader msgHeader = new MsgHeader();
        MessageType msgType = new MessageType();
        BitFieldMap bitFieldMap = new BitFieldMap();
        FieldData fieldData = new FieldData();

        // 设置域值
        List<Field> fields = new ArrayList<Field>();

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
        msgType.setMsgType("0830");
        response.setMsgType(msgType);
        // 结束处理消息类型



        // 设置位图
        bitFieldMap.setFields(fields);
        response.setBitFieldMap(bitFieldMap);


        // 设置域值
        try {
            fieldData.encode(fields);
            response.setFieldData(fieldData);

            // 设置消息头
            int totalLen = MsgHeader.MSG_HEADER_SIZE + MessageType.MSG_TYPE_SIZE + bitFieldMap.getBitFieldMapLen() + fieldData.getFieldDataLen();
            msgHeader.encodeMsgHeader(totalLen, "48020000", "B0210029", (byte)0, "00000000", (byte)0, "00000");
            response.setMsgHeader(msgHeader);

            // 消息编码,这一步非常重要，把msgHeader, msgType, bitFieldMap, fieldData合成msgContent
            response.encode();


        } catch (IOException e) {
            e.printStackTrace();
        }




        // 发送应答消息
       // request.getChannelHandlerContext().writeAndFlush(response);

        return response;
    }
}
