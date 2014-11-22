package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field57_AS extends Field {

    public Field57_AS()
    {
        fieldName = "组合用法";
        fieldNo = "57.AS";

        fieldType = FIELD_TYPE_N;

        // 3字节长度 + 标志AS + 标志比如AB + 3字节长度 + 数据
        fieldValueType = FIELD_VALUE_TYPE_TV;
        dataLen = 12;
    }
}
