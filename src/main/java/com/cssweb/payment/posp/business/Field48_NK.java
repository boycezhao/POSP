package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_NK extends Field{

    public Field48_NK()
    {
        fieldName = "新密钥";
        fieldNo = 128;

        fieldType = FIELD_TYPE_BINARY_BIT;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 4080;
    }

}
