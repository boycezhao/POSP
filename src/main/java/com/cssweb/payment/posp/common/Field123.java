package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field123 extends Field {

    public Field123()
    {
        fieldName = "发卡方保留";
        fieldNo = "123";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_LLLV;
        maxFieldLength = 100;
    }
}
