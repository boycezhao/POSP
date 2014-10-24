package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_10 extends Field{

    public static final String CARD_PRODUCT_UNKNOWN = "00"; //未知
    public static final String CARD_PRODUCT_GOV = "01"; //公务卡
    public static final String CARD_PRODUCT_PUBLIC = "02"; //公共缴费类卡
    public static final String CARD_PRODUCT_AIR = "03"; //航空卡
    public static final String CARD_PRODUCT_STUDENT = "04"; //学生卡
    public static final String CARD_PRODUCT_SOCIAL = "05"; //社保卡
    public static final String CARD_PRODUCT_TRAFFIC = "06"; //交通卡
    public static final String CARD_PRODUCT_COUPON = "07"; //积分卡
    public static final String CARD_PRODUCT_SOLDIER = "08"; //军人卡
    public static final String CARD_PRODUCT_CITIZEN = "09"; //市民卡

    public Field60_3_10()
    {
        fieldName = "卡产品";
        fieldNo = "60.3.10";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2;
    }
}
