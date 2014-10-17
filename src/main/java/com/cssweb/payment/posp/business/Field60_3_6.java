package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_6 extends Field{

    public static final String CARD_MATERIAL_UNKNOWN = "0";
    public static final String CARD_MATERIAL_MAGNETIC = "1";
    public static final String CARD_MATERIAL_IC = "2";
    public static final String CARD_MATERIAL_FALLBACK = "3";
    public static final String CARD_MATERIAL_VIRTUAL = "4";
    public static final String CARD_MATERIAL_PURE_CHAR = "5";
    public static final String CARD_MATERIAL_BIOLOGY = "6";
    public static final String CARD_MATERIAL_NO = "7";



    public Field60_3_6()
    {
        fieldName = "交易介质";
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
