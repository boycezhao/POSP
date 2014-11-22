package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/11/3.
 */
public class Field48_AS_IN extends Field {

    public Field48_AS_IN()
    {
        fieldName = "预付卡发卡机构ecure认证信息";
        fieldNo = "48.AS.IN";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_TLLLV;
        tag = "IN";
        maxFieldLength = 255;
    }
}
