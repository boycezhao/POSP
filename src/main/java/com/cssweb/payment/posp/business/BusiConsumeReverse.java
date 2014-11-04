package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.network.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhf on 2014/10/15.
 */
public class BusiConsumeReverse implements BusinessAction {

    private static final Logger logger = LogManager.getLogger(BusiConsumeReverse.class.getName());

    @Override
    public CustomMessage process(CustomMessage request) {

        logger.info("==处理消费冲正==");

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



        msgType.setMsgType("0430");

        return response;
    }
}
