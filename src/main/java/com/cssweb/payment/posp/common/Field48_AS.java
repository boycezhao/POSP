package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field48_AS extends Field {

    private Field48_AA fieldIN;
    private Field48_PB fieldPB;
    private Field48_IP fieldIP;
    private Field48_RA fieldRA;
    private Field48_RP fieldRP;

    public Field48_AS()
    {
        fieldName = "组合用法";
        fieldNo = "48.AS";

       // fieldType = FIELD_TYPE_N;

        fieldValueType = FIELD_VALUE_TYPE_TV;
        tag = "AS";
       // dataLen = 12;
        // 3字节长度 + 标志AS + 标志 + 2字节长度 + 数据?
    }
}
