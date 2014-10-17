package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_7 extends Field{

    public static final String CARD_APP_TYPE_UNKNOWN = "0";
    public static final String CARD_APP_TYPE_PBOC = "1";
    public static final String CARD_APP_TYPE_EMV = "2";
    public static final String CARD_APP_TYPE_CASH = "3";
    public static final String CARD_APP_TYPE_WALLET = "4";
    public static final String CARD_APP_TYPE_MSD = "5";


    public Field60_3_7()
    {
        fieldName = "IC卡的应用类型";
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
