package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field90_5 extends Field {

    //对应域f33
    public Field90_5()
    {
        fieldName = "原始发送机构标识码";
        fieldNo = "90.5";// 对应域33

        fieldType = FIELD_TYPE_ANS;
        dataLen = 11;
        beginPos = 31;
    }
}
