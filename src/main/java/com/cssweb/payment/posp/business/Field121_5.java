package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_5 extends Field {


    public Field121_5()
    {
        fieldName = "转入和转出方标识代码/手续费信息";
        fieldNo = "121.5";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 38;

        //fieldValue = new byte[fieldLength];

        beginPos = 43;
        isSubField = true;
    }
}
