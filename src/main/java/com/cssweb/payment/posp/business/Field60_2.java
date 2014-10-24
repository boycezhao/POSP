package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field60_2 extends Field{

    public Field60_2()
    {
        fieldName = "服务点附加信息";
        fieldNo = "60.2";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 11;

        isSubField = true;
        hasSubField = true;
    }
}
