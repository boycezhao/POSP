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
        logger.info(reqField121.toString());

        Field128 reqField128 = (Field128) reqFieldData.getField(128);
        logger.info(reqField128.toString());

        CustomMessage response = new CustomMessage();


        return response;
    }
}
