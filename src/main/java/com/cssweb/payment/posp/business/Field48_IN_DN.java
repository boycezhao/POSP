package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field48_IN_DN extends Field{
    public Field48_IN_DN()
    {
        fieldName = "证书DN取值";
        fieldNo = 128;

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 255;
    }
}
