package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_4 extends Field {

    public static final String FLAG_CUP = "CUP";
    public static final String FLAG_VISA = "VIS";
    public static final String FLAG_MASTER_CARD = "MCC";


    public Field61_4()
    {
        fieldName = "无卡校验值";
        fieldNo = "61.4";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 7;


    }
}
