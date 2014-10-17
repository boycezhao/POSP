package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_5 extends Field{

    public static final String TRADE_WAY_UNKNOWN = "0";
    public static final String TRADE_WAY_COUNTER = "1";
    public static final String TRADE_WAY_SELF_SERVICE = "2";
    public static final String TRADE_WAY_AGENT = "3";

    public Field60_3_5()
    {
        fieldName = "交易发起方式";
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
