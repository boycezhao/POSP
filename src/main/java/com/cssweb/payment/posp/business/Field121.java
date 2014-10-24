package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field121 extends Field {

    public Field121()
    {
        fieldName = "预付卡发卡机构保留";
        fieldNo = "121";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 100;

        isSubField = true;
    }
}
