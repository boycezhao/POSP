package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_6 extends Field{
    public Field61_6()
    {
        fieldName = "安全信息校验值";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 168;

        isSubField = true;
    }
}
