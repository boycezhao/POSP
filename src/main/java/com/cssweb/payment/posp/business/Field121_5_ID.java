package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/27.
 */
public class Field121_5_ID extends Field {

    public Field121_5_ID()
    {
        fieldName = "original bank/cardholder bank IDentifier转入转出方标识代码";
        fieldNo = "121.5.ID";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 38;

        fieldValueType = FIELD_VALUE_TYPE_TL;
        tag = "ID";
        valueLen = 36;

        isSubField = true;
    }
}
