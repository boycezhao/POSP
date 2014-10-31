package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/22.
 */
public class Field48_PB extends Field {
    private Field22 field22;
    private Field60_2_3 field60_2_3;

    public Field48_PB()
    {
        fieldName = "基于PBOC电子钱包/存折标准和基于PBOC借贷记标准的电子现金应用的非指定账户圈存信息";
        fieldNo = "48.PB";

        fieldType = FIELD_TYPE_BINARY_BIT;


        dataLen = 4080;

    }
}
