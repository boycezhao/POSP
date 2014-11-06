package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field18  extends Field {
    public Field18()
    {
        //取值请参见GB/T 20548-2006《金融零售业务 商户类别代码》

        fieldName = "商户类型";
        fieldNo = "18";

        fieldType = FIELD_TYPE_N;


        dataLen = 4;
    }
}
