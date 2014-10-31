package com.cssweb.payment.posp.business;


import com.cssweb.payment.posp.network.MessageType;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_CD extends Field {

    //交易是否相关标志
    private String flag;

    private MessageType msgType;
    private Field11 field11;
    private Field7 field7;
    private Field32 field32;
    private Field33 field33;
    private Field41 field41;
    private Field42 field42;


    public Field48_CD()
    {
        fieldName = "收/付费理由";
        fieldNo = "48.CD";

        fieldType = FIELD_TYPE_ANSB;

        fieldValueType = FIELD_VALUE_TYPE_LLLV;
        maxFieldLength = 249;
    }
}
