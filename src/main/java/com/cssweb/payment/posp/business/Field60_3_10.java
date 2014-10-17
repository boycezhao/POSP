package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_10 extends Field{

    public static final String CARD_PRODUCT_UNKNOWN = "00";
    public static final String CARD_PRODUCT_GOV = "01";
    public static final String CARD_PRODUCT_PUBLIC = "02";
    public static final String CARD_PRODUCT_AIR = "03";
    public static final String CARD_PRODUCT_STUDENT = "04";
    public static final String CARD_PRODUCT_SOCIAL = "05";
    public static final String CARD_PRODUCT_TRAFFIC = "06";
    public static final String CARD_PRODUCT_COUPON = "07";
    public static final String CARD_PRODUCT_SOLDIER = "08";
    public static final String CARD_PRODUCT_CITIZEN = "09";

    public Field60_3_10()
    {
        fieldName = "卡产品";
        //fieldNo =
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2;
    }
}
