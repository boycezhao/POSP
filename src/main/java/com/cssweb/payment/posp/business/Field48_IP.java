package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_IP extends Field{
    private String periods;
    private String items;
    private String reserved;

    public Field48_IP()
    {
        fieldName = "分期付款信息";
        fieldNo = 128;

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 255;
    }
}
