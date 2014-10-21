package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field122_2 extends Field{

    public Field122_2()
    {
        fieldName = "受理方信息";

        fieldType = FIELD_TYPE_ANS;
        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        maxFieldLength = 94;

        isSubField = true;
    }
}
