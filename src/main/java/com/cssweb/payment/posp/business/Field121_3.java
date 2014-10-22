package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_3 extends Field{
    public static final String CARD_TYPE_CUP_CREDIT = "9";
    public static final String CARD_TYPE_CUP_DEBIT = "C";
    public static final String CARD_TYPE_CUP_SEMI_CREDIT = "A";
    public static final String CARD_TYPE_CUP_ONE_CARD = "D";
    public static final String CARD_TYPE_CUP_PREPAY = "E";
    public static final String CARD_TYPE_CUP_HALFOPEN_PREPAY = "F";

    public static final String CARD_TYPE_NONCUP_CREDIT = "1";
    public static final String CARD_TYPE_NONCUP_DEBIT = "4";
    public static final String CARD_TYPE_NONCUP_SEMI_CREDIT = "2";
    public static final String CARD_TYPE_NONCUP_ONE_CARD = "5";
    public static final String CARD_TYPE_NONCUP_PREPAY = "6";
    public static final String CARD_TYPE_NONCUP_HALFOPEN_PREPAY = "7";

    public Field121_3()
    {
        fieldName = "卡性质";
        //fieldNo = "";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;

        isSubField = true;
    }
}
