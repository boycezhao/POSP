package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_6 extends Field {
    public static final String VERIFY_PWD = "0"; //非免验密码网络
    public static final String NO_PWD = "1"; //免验密码网络

    public Field60_2_6()
    {
        fieldName = "免验密码网络标志";
        fieldNo = "60.2.6";


        dataLen = 1;
    }
}
