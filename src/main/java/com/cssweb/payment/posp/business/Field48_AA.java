package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_AA extends Field{

    public Field48_AA()
    {
        fieldName = "受理方附加交易信息";
        fieldNo = 128;

        fieldType = FIELD_TYPE_ANSB;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 510;
    }
}
