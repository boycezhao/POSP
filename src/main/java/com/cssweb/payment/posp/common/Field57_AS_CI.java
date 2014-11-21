package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field57_AS_CI extends Field {

    private String name;
    private String idKind;
    private String idno;
    private String phone;
    private String others;

    public Field57_AS_CI()
    {
        fieldName = "6.44.7.1.3　持卡人身份信息";
        fieldNo = "57.CI";

        fieldType = FIELD_TYPE_N;
        fieldValueType = FIELD_VALUE_TYPE_TLLLV;

        dataLen = 20 + 2 + 20 + 14 + 42;


    }
}
