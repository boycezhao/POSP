package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_NK extends Field {

    public Field48_NK()
    {
        fieldName = "新密钥";
        fieldNo = "48.NK";



        fieldType = FIELD_TYPE_BINARY_BIT;

        fieldValueType = FIELD_VALUE_TYPE_TV;
        tag = "NK";
        dataLen = 4080/8; // 510字节
    }

}
