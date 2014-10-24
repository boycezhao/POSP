package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_9 extends Field{

    public static final String CARD_ACC_LEVEL_UNKNOWN = "0"; //未知
    public static final String CARD_ACC_LEVEL_NORMAL = "1"; //普卡
    public static final String CARD_ACC_LEVEL_SILVER = "2"; //银卡
    public static final String CARD_ACC_LEVEL_GOLDEN = "3"; //金卡
    public static final String CARD_ACC_LEVEL_PLATINUM = "4"; //白金卡
    public static final String CARD_ACC_LEVEL_DIAMOND = "5"; //钻石卡
    public static final String CARD_ACC_LEVEL_UNLIMITED = "6"; //无限卡


    public Field60_3_9()
    {
        fieldName = "卡账户等级";
        fieldNo = "60.3.9";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
