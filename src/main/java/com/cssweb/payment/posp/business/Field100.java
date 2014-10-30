package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field100 extends Field {

    public Field100()
    {
        fieldName = "接收机构标识码";
        fieldNo = "100";

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR2;
        maxFieldLength = 2+11;
       // fieldValue = new byte[maxFieldLength];
    }
}
