package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/11/3.
 */
public class Field48_AS_AA extends Field {

    public Field48_AS_AA()
    {
        fieldName = "受理方附加交易信息";
        fieldNo = "48.AS.AA";

        fieldType = FIELD_TYPE_AN;

        fieldValueType = FIELD_VALUE_TYPE_TLLV;
        tag = "AA";
        dataLen = 26;
        maxFieldLength = 26;
    }
}
