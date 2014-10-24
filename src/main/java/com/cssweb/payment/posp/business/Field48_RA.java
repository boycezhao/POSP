package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_RA extends Field{

    public Field48_RA()
    {
        fieldName = "折扣消费交易中的刷卡金额";
        fieldNo = "48.RA";

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 12;
    }
}
