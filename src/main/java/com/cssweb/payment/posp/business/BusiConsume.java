package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.network.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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


        try {
            Field3 field3 = new Field3();

            field3.setData("00X000");
            System.out.println(field3.toString());
            fields.add(field3);



        } catch (OverflowMaxLengthException e) {
            e.printStackTrace();
        } catch (FieldLengthException e) {
            e.printStackTrace();
        }



        msgType.setMsgType("0210");

        return response;
    }
}
