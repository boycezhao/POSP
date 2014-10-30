package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/27.
 */
public class Field121_5_FD extends Field {

    public Field121_5_FD()
    {
        fieldName = "Fee Detail手续费信息";
        fieldNo = "121.5.FD";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 38;


        fieldValueType = FIELD_VALUE_TYPE_TL;
        tag = "FD";

        isSubField = true;
    }
}
