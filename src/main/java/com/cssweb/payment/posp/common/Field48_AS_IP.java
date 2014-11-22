package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/11/3.
 */
public class Field48_AS_IP extends Field {

    public Field48_AS_IP()
    {
        fieldName = "分期付款信息";
        fieldNo = "48.AS.IP";

        fieldType = FIELD_TYPE_N;

        fieldValueType = FIELD_VALUE_TYPE_TLLV;
        tag = "IP";
        dataLen = 2+30+30;
    }
}
