package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.network.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenhf on 2014/10/15.
 */
public class BusiConsume  implements BusinessAction {

    private static final Logger logger = LogManager.getLogger(BusiConsume.class.getName());

    @Override
    public CustomMessage process(CustomMessage request) {
        logger.info("==处理消费==");

        CustomMessage response = new CustomMessage();
        MsgHeader msgHeader = new MsgHeader();
        MessageType msgType = new MessageType();
        BitFieldMap bitFieldMap = new BitFieldMap();
        FieldData fieldData = new FieldData();
        List<Field> fields = new ArrayList<Field>();

        FieldData reqFieldData = request.getFieldData();
        logger.info(reqFieldData.toString());


        try {


            Field2 f2 = (Field2) reqFieldData.getField(2);
            logger.info(f2.toString());
            fields.add(f2);

            Field3 f3 = (Field3) reqFieldData.getField(3);
            logger.info(f3.toString());
            fields.add(f3);

            Field4 f4 = (Field4) reqFieldData.getField(4);
            logger.info(f4.toString());
            fields.add(f4);


            Field7 f7 = (Field7) reqFieldData.getField(7);
            logger.info(f7.toString());
            fields.add(f7);

            Field11 f11 = (Field11) reqFieldData.getField(11);
            logger.info(f11.toString());
            fields.add(f11);

            Field12 f12 = (Field12) reqFieldData.getField(12);
            logger.info(f12.toString());
            fields.add(f12);

            Field13 f13 = (Field13) reqFieldData.getField(13);
            logger.info(f13.toString());
            fields.add(f13);


            // 卡有效期
            Field14 field14 = new Field14();
            field14.setData("1612"); // 2016年12月份
            logger.info(field14.toString());
            fields.add(field14);

            Field15 f15 = (Field15) reqFieldData.getField(15);
            logger.info(f15.toString());
            fields.add(f15);

            Field18 f18 = (Field18) reqFieldData.getField(18);
            logger.info(f18.toString());
            fields.add(f18);

            Field25 f25 = (Field25) reqFieldData.getField(25);
            logger.info(f25.toString());
            fields.add(f25);

            Field32 f32 = (Field32) reqFieldData.getField(32);
            logger.info(f32.toString());
            fields.add(f32);

            Field33 f33 = (Field33) reqFieldData.getField(33);
            logger.info(f33.toString());
            fields.add(f33);

            Field37 f37 = (Field37) reqFieldData.getField(37);
            logger.info(f37.toString());
            fields.add(f37);

            //授权标识应答码
            Field38 f38 = new Field38();

            //应答码
            Field39 field39 = new Field39();
            field39.setData(ResponseCode.RC_SUCCESS);
            logger.info(field39.toString());
            fields.add(field39);


            Field41 f41 = (Field41) reqFieldData.getField(41);
            logger.info(f41.toString());
            fields.add(f41);

            Field42 f42 = (Field42) reqFieldData.getField(42);
            logger.info(f42.toString());
            fields.add(f42);

            //附加响应数据
            Field44 f44 = new Field44();

            Field49 f49 = (Field49) reqFieldData.getField(49);
            logger.info(f49.toString());
            fields.add(f49);

            //附加交易信息
            Field57 f57 = new Field57();
            //f57.setData();
            //fields.add(f57);

            Field100 f100 = (Field100) reqFieldData.getField(100);
            logger.info(f100.toString());
            fields.add(f100);

            Field121 f121 = (Field121) reqFieldData.getField(121);
            //logger.info(reqField121.toString());
            Field121_1 field121_1 = (Field121_1) f121.getSubField("121.1");
            logger.info(field121_1.toString());
            Field121_2 field121_2 = (Field121_2) f121.getSubField("121.2");
            logger.info(field121_2.toString());
            Field121_3 field121_3 = (Field121_3) f121.getSubField("121.3");
            logger.info(field121_3.toString());
            Field121_4 field121_4 = (Field121_4) f121.getSubField("121.4");
            logger.info(field121_4.toString());
            Field121_5 field121_5 = (Field121_5) f121.getSubField("121.5");

            Field121_5_ID id = (Field121_5_ID) field121_5.getSubFieldByTag();
            logger.info(id.toString());
            logger.info(field121_5.toString());

            fields.add(f121);

            //发卡方保留
            Field123 field123 = new Field123();
            field123.setData("issuer reserved");
            logger.info(field123.toString());
            fields.add(field123);




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
            msgType.setMsgType("0210");

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
