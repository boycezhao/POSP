package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_4 extends Field{

    public static final String  TRADE_RETURN_BALANCE_NOT_SUPPORT = "0"; //不支持
    public static final String  TRADE_RETURN_BALANCE_SUPPORT = "1"; //支持

    public Field60_3_4()
    {
        fieldName = "支持部分承兑和返回余额标志";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
