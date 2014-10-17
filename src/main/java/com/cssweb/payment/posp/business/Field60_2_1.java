package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_1 extends Field{

    public static final String ACCOUNT_TYPE_PERSONAL_CARD = "0";
    public static final String ACCOUNT_TYPE_PERSONAL = "1";
    public static final String ACCOUNT_TYPE_ENTERPRISE = "2";
    public static final String ACCOUNT_TYPE_ENTERPRISE_CARD = "3";
    public static final String ACCOUNT_TYPE_UNKNOWN = "9";
    public static final String ACCOUNT_TYPE_COUPON = "A";


    public Field60_2_1()
    {
        fieldName = "账户所有人类型";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
