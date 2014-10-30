package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field57_AS_RA extends Field {
    public Field57_AS_RA()
    {
        fieldName = "6.44.7.1.5　原始请求金额";
        fieldNo = "57.AS.RA";

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 12;

        isSubField = true;

    }
}
