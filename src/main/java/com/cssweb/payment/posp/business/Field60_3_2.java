package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_2 extends Field{

    public static final String BILL_CLASS_0 = "0"; // 无特殊计费档次，普通商户，大商户优惠1级
    public static final String BILL_CLASS_1 = "1"; //                 三农商户，大商户优惠2级
    public static final String BILL_CLASS_2 = "2";//                            大商户优惠3级


    public Field60_3_2()
    {
        fieldName = "特殊计费档次";
        fieldNo = "60.3.2";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
