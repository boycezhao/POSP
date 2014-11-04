package com.cssweb.payment.posp.client;

import com.cssweb.payment.posp.business.*;
import com.cssweb.payment.posp.network.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by chenhf on 2014/11/3.
 */
public class TestApplyKey {
    public CustomMessage getRequest() {
        Date now = new Date();
        StringBuffer sb = new StringBuffer();

        String AC_ID = "00000000000";
        String SW_ID = "11111111111";
        String IS_ID = "22222222222";
        String referNo = "181030414357"; // 参考号
        String terminalNo = "63856007"; // 终端号
        String batchNo = "000216"; // 批次号
        String authNo = "571462"; // 授权码
        String voucherNo = "005572"; // 凭证号
        String merchantNo = "102310058125081"; // 商户编号


        CustomMessage request = new CustomMessage();

        MsgHeader msgHeader = new MsgHeader();
        MessageType msgType = new MessageType();
        BitFieldMap bitFieldMap = new BitFieldMap();
        FieldData fieldData = new FieldData();
        List<Field> fields = new ArrayList<Field>();

        try {




            // 交易传输时间
            Field7 field7 = new Field7();
            SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
            String tranTime = sdf.format(now);
            field7.setData(tranTime);
            System.out.println(field7.toString());
            fields.add(field7);


            //系统跟踪号
            Field11 field11 = new Field11();
            String traceNo = "";
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                traceNo += random.nextInt(10);
            }
            field11.setData(traceNo);
            System.out.println(field11.toString());
            fields.add(field11);



            //发送机构标识码
            Field33 field33 = new Field33();
            field33.setData(IS_ID);
            System.out.println(field33.toString());
            fields.add(field33);




            //安全控制信息
            Field53 field53 = new Field53();
            String f53 = Field53.PIN_FORMAT_PAN + Field53.ENCRYPTION_METHOD_DOUBLE + Field53.RESERVED;
            field53.setData(f53);
            //field53.setPinFormat(Field53.PIN_FORMAT_PAN);
            //field53.setEncAlgo(Field53.ENCRYPTION_METHOD_DOUBLE);
            System.out.println(field53.toString());
            fields.add(field53);

            Field70 field70 = new Field70();
            field70.setData("101");
            System.out.println(field70.toString());
            fields.add(field70);

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
            msgType.setMsgType("0820");

            // 设置消息头
            totalLen = MsgHeader.MSG_HEADER_SIZE + MessageType.MSG_TYPE_SIZE + bitFieldMap.getBitFieldMapLen() + fieldData.getFieldDataLen();
            msgHeader.encode(totalLen, "48020000", "B0210029", (byte) 0, "00000000", (byte) 0, "00000");

            // 消息编码,这一步非常重要，把msgHeader, msgType, bitFieldMap, fieldData合成msgContent
            request.setMsgHeader(msgHeader);
            request.setMsgType(msgType);
            request.setBitFieldMap(bitFieldMap);
            request.setFieldData(fieldData);

            //
            request.encode();

            return request;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FieldLengthException e) {
            e.printStackTrace();
        } catch (OverflowMaxLengthException e) {
            e.printStackTrace();
        }

        return null;
    }
}
