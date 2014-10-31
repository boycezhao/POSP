package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_5 extends Field {

    public static final String ARQC_SUCCESS = "1"; //交易通过ARQC认证
    public static final String ARQC_FAIL = "2"; // 交易未能通过ARQC认证
    public static final String ARQC_UNKNOWN = "3"; // 没有进行ARQC认证

    public Field61_5()
    {
        fieldName = "ARQC认证结果值";
        fieldNo = "61.5";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 1;


    }
}
