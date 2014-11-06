package com.cssweb.payment.posp.business;


import com.cssweb.payment.posp.common.Field;
import com.cssweb.payment.posp.network.CustomMessage;
import com.cssweb.payment.posp.network.FieldData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;

/**
 * Created by chenhf on 2014/10/15.
 */
public class BusiApplyKey implements BusinessAction {

    private static final Logger logger = LogManager.getLogger(BusiApplyKey.class.getName());

    @Override
    public CustomMessage process(CustomMessage request) {
        logger.info("==申请密钥:显示银联商务的应答==");

        FieldData fieldData = request.getFieldData();
        logger.info(fieldData.toString());

        LinkedHashMap<Integer, Field> fieldMap  = fieldData.getFieldMap();
        for (Field field : fieldMap.values())
        {
            logger.info(field.toString());
        }

        return null;
    }
}
