package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_RP extends Field {

    private String code; //商品代码
    private String reserved; //保留使用

    public Field48_RP()
    {
        fieldName = "积分兑换信息";
        fieldNo = "48.RP";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_TV;
        tag = "RP";
        dataLen = 30 + 30;
    }

}
