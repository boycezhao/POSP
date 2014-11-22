package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_BC extends Field {
    private String risk;
    private byte riskLevel;
    private String riskScore;
    private String reserved = "";

    public Field48_BC()
    {
        fieldName = "可疑欺诈交易通知信息";
        fieldNo = "48.BC";

        fieldType = FIELD_TYPE_ANS;
        fieldValueType = FIELD_VALUE_TYPE_TV;
        tag = "BC";
        dataLen = 3 + 1 + 3 + 12;
    }
}
