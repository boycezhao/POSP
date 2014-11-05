package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field96 extends Field {

    public Field96()
    {
        fieldName = "报文安全码";
        fieldNo = "96";

        fieldType = FIELD_TYPE_BINARY_BIT;

        dataLen = 64/8;
    }
}
