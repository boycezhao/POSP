package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_6 extends Field{

    public static final String CARD_MATERIAL_UNKNOWN = "0";  //未知
    public static final String CARD_MATERIAL_MAGNETIC = "1"; // 磁条卡
    public static final String CARD_MATERIAL_IC = "2"; // IC卡
    public static final String CARD_MATERIAL_FALLBACK = "3"; //Fall Back卡
    public static final String CARD_MATERIAL_VIRTUAL = "4"; // 虚拟卡
    public static final String CARD_MATERIAL_PURE_CHAR = "5"; // 纯字符
    public static final String CARD_MATERIAL_BIOLOGY = "6"; // 生物特征
    public static final String CARD_MATERIAL_NO = "7"; // 无卡



    public Field60_3_6()
    {
        fieldName = "交易介质";
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
