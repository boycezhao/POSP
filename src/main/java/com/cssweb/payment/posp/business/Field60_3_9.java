package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_9 extends Field{

    public static final String CARD_ACC_LEVEL_UNKNOWN = "0";
    public static final String CARD_ACC_LEVEL_NORMAL = "1";
    public static final String CARD_ACC_LEVEL_SILVER = "2";
    public static final String CARD_ACC_LEVEL_GOLDEN = "3";
    public static final String CARD_ACC_LEVEL_PLATINUM = "4";
    public static final String CARD_ACC_LEVEL_DIAMOND = "5";
    public static final String CARD_ACC_LEVEL_UNLIMITED = "6";


    public Field60_3_9()
    {
        fieldName = "卡账户等级";
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
