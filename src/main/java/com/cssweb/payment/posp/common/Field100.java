package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field100 extends Field {

    public Field100()
    {
        fieldName = "接收机构标识码";
        fieldNo = "100";

        fieldType = FIELD_TYPE_N;

        fieldValueType = FIELD_VALUE_TYPE_LLV;
        maxFieldLength = 11;

    }
}
