package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/11/3.
 */
public class Field48_AS_RP extends Field {

    public Field48_AS_RP()
    {
        fieldName = "积分兑换信息";
        fieldNo = "48.AS.RP";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_TLLV;
        tag = "RP";
        dataLen = 30+30;
    }
}
