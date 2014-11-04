package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.network.CustomMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by chenhf on 2014/10/15.
 */
public class BusiConsumeCancel implements BusinessAction {

    private static final Logger logger = LogManager.getLogger(BusiConsumeCancel.class.getName());

    @Override
    public CustomMessage process(CustomMessage request) {
        logger.info("==处理消费撤消==");

        return null;
    }
}
