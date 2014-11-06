package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_2 extends Field {

    public static final String CC_UNKNOWN = "1"; // 预付卡发卡机构未做处理
    public static final String CC_SINGLE = "2"; // 受理方提供的单信息交易由预付卡发卡机构转换成双信息处理
    public static final String CC_DOUBLE = "3"; // 受理方提供的双信息交易由预付卡发卡机构转换成单信息处理

    public Field121_2()
    {
        fieldName = "单/双或双/单转换码";
        fieldNo = "121.2";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 1;


        beginPos = 1;
    }
}
