package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field61 extends Field {

    public Field61()
    {
        fieldName = "持卡人身份认证信息";
        fieldNo = "61";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 200;

        hasSubField = true;

    }
}
