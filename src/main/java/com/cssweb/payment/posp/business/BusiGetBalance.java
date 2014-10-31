package com.cssweb.payment.posp.business;


import com.cssweb.payment.posp.network.CustomMessage;
import com.cssweb.payment.posp.network.FieldData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by chenhf on 2014/8/25.
 */
public class BusiGetBalance implements BusinessAction {

    private static final Logger logger = LogManager.getLogger(BusiGetBalance.class.getName());



    @Override
    public CustomMessage process(CustomMessage request) {

        FieldData reqFieldData = request.getFieldData();
        logger.info(reqFieldData.toString());

        Field2 reqField2 = (Field2) reqFieldData.getField(2);
        logger.info(reqField2.toString());

        Field100 reqField100 = (Field100) reqFieldData.getField(100);
        logger.info(reqField100.toString());

        Field121 reqField121 = (Field121) reqFieldData.getField(121);
        //logger.info(reqField121.toString());
        Field121_1 field121_1 = (Field121_1) reqField121.getSubField("121.1");
        logger.info(field121_1.toString());
        Field121_2 field121_2 = (Field121_2) reqField121.getSubField("121.2");
        logger.info(field121_2.toString());
        Field121_3 field121_3 = (Field121_3) reqField121.getSubField("121.3");
        logger.info(field121_3.toString());
        Field121_4 field121_4 = (Field121_4) reqField121.getSubField("121.4");
        logger.info(field121_4.toString());
        Field121_5 field121_5 = (Field121_5) reqField121.getSubField("121.5");

        Field121_5_ID id = (Field121_5_ID) field121_5.getSubFieldByTag();
        logger.info(id.toString());
        logger.info(field121_5.toString());

        Field128 reqField128 = (Field128) reqFieldData.getField(128);
        logger.info(reqField128.toString());

        CustomMessage response = new CustomMessage();


        return response;
    }
}
