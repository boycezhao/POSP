package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field48 extends Field {

    public Field48()
    {
        fieldName = "附加数据－私有";
        fieldNo = 48;

        fieldType = FIELD_TYPE_ANSB;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 512;
    }
}
