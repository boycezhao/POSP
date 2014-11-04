package com.cssweb.payment.posp;

import com.cssweb.payment.posp.client.TestApplyKey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by chenhf on 2014/10/28.
 */
public class ApplyKeyUnitTest {
    private static final Logger logger = LogManager.getLogger(ApplyKeyUnitTest.class.getName());

    public static void main(String[] args)
    {
        TestApplyKey test = new TestApplyKey();
        test.getRequest();


    }
}
