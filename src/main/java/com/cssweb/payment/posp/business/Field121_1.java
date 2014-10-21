package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_1 extends Field{
    public Field121_1()
    {
        fieldName = "应答原因码";
        //fieldNo = "";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;

        isSubField = true;
    }
}
