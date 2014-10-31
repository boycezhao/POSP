package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field48_AS extends Field {

    private Field48_AA fieldIN;
    private Field48_PB fieldPB;
    private Field48_IP fieldIP;
    private Field48_RA fieldRA;
    private Field48_RP fieldRP;

    public Field48_AS()
    {
        fieldName = "组合用法";
        fieldNo = "48.AS";

        fieldType = FIELD_TYPE_N;

        fieldValueType = FIELD_VALUE_TYPE_TV;
        dataLen = 12;
    }
}
