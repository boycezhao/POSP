package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field60_1 extends Field{

    public Field60_1()
    {
        fieldName = "报文原因码";


        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 4;

        isSubField = true;
    }
}
