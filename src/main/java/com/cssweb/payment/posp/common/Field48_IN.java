package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_IN extends Field {

    private Field48_IN_DN dn;

    public Field48_IN_DN getDn() {
        return dn;
    }

    public void setDn(Field48_IN_DN dn) {
        this.dn = dn;
    }

    public Field48_IN()
    {
        fieldName = "预付卡发卡机构ecure认证信息";
        fieldNo = "48.IN";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 2+20+2+20+14+42;
    }
}
