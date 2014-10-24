package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field42 extends Field {
    public Field42()
    {
        fieldName = "受卡方标识码";
        fieldNo = "42";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 15;
    }

}
