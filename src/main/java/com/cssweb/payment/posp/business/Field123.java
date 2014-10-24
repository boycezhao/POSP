package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field123 extends Field {

    public Field123()
    {
        fieldName = "发卡方保留";
        fieldNo = "123";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 100;
    }
}
