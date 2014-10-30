package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_4 extends Field {
    public Field121_4()
    {
        fieldName = "预付卡发卡机构保留";
        fieldNo = "121.4";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 40;
       // maxFieldLength = 50;

        isSubField = true;
        beginPos = 3;
    }
}
