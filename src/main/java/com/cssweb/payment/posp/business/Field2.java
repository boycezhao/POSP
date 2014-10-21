package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/8/20.
 */
public class Field2 extends Field{

    public Field2()
    {
        fieldName = "主账号";
        fieldNo = 2;

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR2;
        maxFieldLength = 19;
    }


}
