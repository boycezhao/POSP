package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_3 extends Field {

    public Field60_3_3()
    {
        fieldName = "保留使用";
        fieldNo = "60.3.3";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 3;

        fieldValue = "000".getBytes();
    }
}
