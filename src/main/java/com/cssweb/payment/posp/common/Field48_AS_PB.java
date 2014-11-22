package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/11/3.
 */
public class Field48_AS_PB extends Field {

    public Field48_AS_PB()
    {
        fieldName = "基于PBOC电子钱包/存折标准和基于PBOC借贷记标准的电子现金应用的非指定账户圈存信息";
        fieldNo = "48.AS.PB";

        fieldType = FIELD_TYPE_N;

        fieldValueType = FIELD_VALUE_TYPE_TLLV;
        tag = "PB";
        dataLen = 3+1;
    }
}
