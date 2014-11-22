package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/11/3.
 */
public class Field48_AS_RA extends Field {
    public Field48_AS_RA()
    {
        fieldName = "折扣消费交易中的刷卡金额";
        fieldNo = "48.AS.RA";

        fieldType = FIELD_TYPE_N;

        fieldValueType = FIELD_VALUE_TYPE_TLLV;
        tag = "RA";
        dataLen = 12;
    }
}
