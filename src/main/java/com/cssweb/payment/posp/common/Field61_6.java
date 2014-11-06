package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_6 extends Field {

    private Field61_6_AM fieldAM;

    public Field61_6_AM getFieldAM() {
        return fieldAM;
    }

    public void setFieldAM(Field61_6_AM fieldAM) {
        this.fieldAM = fieldAM;
    }

    public Field61_6()
    {
        fieldName = "安全信息校验值";
        fieldNo = "61.6";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_LLLV;
        maxFieldLength = 168;


    }
}
