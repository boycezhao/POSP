package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field61_6_NM extends Field {

    private String name1;
    private String name2;

    public Field61_6_NM()
    {
        fieldName = "持卡人姓名";
        fieldNo = "61.6.NM";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 60;


    }
}
