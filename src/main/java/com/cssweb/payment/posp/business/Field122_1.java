package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field122_1 extends Field{

    public Field122_1()
    {
        fieldName = "商户扣率";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 6;

        isSubField = true;
    }

}