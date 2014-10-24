package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field45 extends Field{
    public Field45()
    {
        fieldName = "第一磁道数据";
        fieldNo = "45";

        fieldType = FIELD_TYPE_Z;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR2;
        maxFieldLength = 79;
    }
}
