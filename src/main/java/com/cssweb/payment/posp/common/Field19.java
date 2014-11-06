package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field19 extends Field {

    public Field19()
    {
        // 参见世界各国和地区名称代码（GB/T 2659-94）
        fieldName = "商户国家代码";
        fieldNo = "19";

        fieldType = FIELD_TYPE_N;


        dataLen = 3;
    }
}
