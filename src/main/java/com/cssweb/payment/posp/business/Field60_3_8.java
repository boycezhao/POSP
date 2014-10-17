package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_8 extends Field{

    public static final String ACC_SETTLEMENT_TYPE_UNKNOWN = "00";
    public static final String ACC_SETTLEMENT_TYPE_DEBIT = "01";
    public static final String ACC_SETTLEMENT_TYPE_CREDIT = "02";
    public static final String ACC_SETTLEMENT_TYPE_QUASI_CREDIT= "03";
    public static final String ACC_SETTLEMENT_TYPE_DEBIT_CREDIT = "04";
    public static final String ACC_SETTLEMENT_TYPE_PREPAY = "05";
    public static final String ACC_SETTLEMENT_TYPE_HALFOPEN_PREPAY = "06";


    public Field60_3_8()
    {
        fieldName = "账户结算类型";
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2;
    }
}
