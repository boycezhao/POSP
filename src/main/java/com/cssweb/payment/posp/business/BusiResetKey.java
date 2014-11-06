package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.common.*;
import com.cssweb.payment.posp.network.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhf on 2014/10/15.
 */
public class BusiResetKey implements BusinessAction {

    private static final Logger logger = LogManager.getLogger(BusiResetKey.class.getName());

    @Override
    public CustomMessage process(CustomMessage request) {
        logger.info("==处理重置密钥==");

        CustomMessage response = new CustomMessage();
        MsgHeader msgHeader = new MsgHeader();
        MessageType msgType = new MessageType();
        BitFieldMap bitFieldMap = new BitFieldMap();
        FieldData fieldData = new FieldData();
        List<Field> fields = new ArrayList<Field>();

        FieldData reqFieldData = request.getFieldData();
        logger.info(reqFieldData.toString());


        try {


            Field7 f7 = (Field7) reqFieldData.getField(7);
            logger.info(f7.toString());
            fields.add(f7);

            Field11 f11 = (Field11) reqFieldData.getField(11);
            logger.info(f11.toString());
            fields.add(f11);




            //应答码
            Field39 field39 = new Field39();
            field39.setData(ResponseCode.RC_SUCCESS);
            logger.info(field39.toString());
            fields.add(field39);





            Field70 f70 = (Field70) reqFieldData.getField(70);
            logger.info(f70.toString());
            fields.add(f70);

            Field96 f96 = (Field96) reqFieldData.getField(96);
            logger.info(f96.toString());
            fields.add(f96);


            Field100 f100 = (Field100) reqFieldData.getField(100);
            logger.info(f100.toString());
            fields.add(f100);




            int totalLen = 0;
            for (Field field : fields) {
                totalLen += field.getFieldLength();
            }
            System.out.println("实际总长度=" + totalLen);

            // 合并各个域的值
            fieldData.encode(fields);
            System.out.println(fieldData.toString());

            // 设置位图
            bitFieldMap.setFields(fields);
            System.out.println(bitFieldMap.showBitFieldMap());

            // 开始处理消息类型
            msgType.setMsgType("0810");

            // 设置消息头
            totalLen = MsgHeader.MSG_HEADER_SIZE + MessageType.MSG_TYPE_SIZE + bitFieldMap.getBitFieldMapLen() + fieldData.getFieldDataLen();
            msgHeader.encode(totalLen, "48020000", "B0210029", (byte) 0, "00000000", (byte) 0, "00000");

            // 消息编码,这一步非常重要，把msgHeader, msgType, bitFieldMap, fieldData合成msgContent
            response.setMsgHeader(msgHeader);
            response.setMsgType(msgType);
            response.setBitFieldMap(bitFieldMap);
            response.setFieldData(fieldData);

            //
            response.encode();
            return response;

        } catch (OverflowMaxLengthException e) {
            e.printStackTrace();
        } catch (FieldLengthException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
