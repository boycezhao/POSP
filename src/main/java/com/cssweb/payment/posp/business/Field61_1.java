package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_1 extends Field{
    public Field61_1()
    {
        fieldName = "证件编号";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 22;

        isSubField = true;
    }
}
