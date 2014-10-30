package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field57_AS_TA extends Field {
    public Field57_AS_TA()
    {
        fieldName = "6.44.7.1.7　本次可充值金额上限（TA）";
        fieldNo = "57.AS.TA";

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 12;

        isSubField = true;
    }

}
