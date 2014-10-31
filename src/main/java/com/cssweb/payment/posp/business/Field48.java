package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field48 extends Field {

    /*
    3字节长度 + 512字节
                2字节标志 + 510字节数据
                as标志 + tag2字节 + length3字节 + value数据字节
     */
    private Field48_CI fieldCI;
    private Field48_RP fieldRP;

    public Field48()
    {
        fieldName = "附加数据－私有";
        fieldNo = "48";

        fieldType = FIELD_TYPE_ANSB;

        fieldValueType = FIELD_VALUE_TYPE_LLLV;
        maxFieldLength = 512;
    }
}
