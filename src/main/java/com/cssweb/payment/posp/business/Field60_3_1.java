package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_1 extends Field {

    public static final String BILL_TYPE_NORMAL = "00"; // 无特殊计费类型
    public static final String BILL_TYPE_PERIOD = "01"; // 周期计费
    public static final String BILL_TYPE_MICRO_AMOUNT_PACKAGE = "02"; // 微额打包计费
    public static final String BILL_TYPE_FIXED_SCALE = "03"; // 固定比例优惠
    public static final String BILL_TYPE_COUNTRY_TOWNSHIP = "04"; // 县乡优惠
    public static final String BILL_TYPE_VIP = "05"; // 大商户优惠


    public Field60_3_1()
    {
        fieldName = "特殊计费类型";
        fieldNo = "60.3.1";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2;
    }
}
