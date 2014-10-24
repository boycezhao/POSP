package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field60  extends Field{

    public Field60()
    {
        fieldName = "自定义域";
        fieldNo = "60";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 100;

        hasSubField = true;
    }
}
