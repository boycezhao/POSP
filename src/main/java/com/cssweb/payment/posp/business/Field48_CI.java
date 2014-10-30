package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_CI extends Field {


    public Field48_CI()
    {
        fieldName = "持卡人身份信息";
        fieldNo = "48.CI";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2+20+2+20+14+42;
    }

}
