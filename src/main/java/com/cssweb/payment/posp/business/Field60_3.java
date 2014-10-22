package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field60_3 extends Field{

    public Field60_3()
    {
        fieldName = "交易发生附加信息";

        fieldLengthType = FIELD_LENGTH_TYPE_VAR2;
        maxFieldLength = 15;


        isSubField = true;
    }
}
