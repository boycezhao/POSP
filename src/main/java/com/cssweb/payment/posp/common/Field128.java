package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field128 extends Field {

    public Field128()
    {
        fieldName = "报文鉴别码";
        fieldNo = "128";

        fieldType = FIELD_TYPE_BINARY_BIT;


        dataLen = 64/8;

    }
}
