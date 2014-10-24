package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field52 extends Field{

    public Field52()
    {
        fieldName = "个人标识码数据";
        fieldNo = "52";

        fieldType = FIELD_TYPE_BINARY_BIT;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 64;
    }

}
