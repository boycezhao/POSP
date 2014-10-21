package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_4 extends Field{
    public Field61_4()
    {
        fieldName = "无卡校验值";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 7;

        isSubField = true;
    }
}
