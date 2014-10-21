package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field122 extends Field{
    public Field122()
    {
        fieldName = "受理方保留";
        fieldNo = 122;

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 100;

        hasSubField = true;
    }
}
