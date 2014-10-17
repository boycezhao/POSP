package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_3 extends Field{

    public static final String IC_CONDITION_CODE_UNKNOWN = "0";
    public static final String IC_CONDITION_CODE_SUCCESS = "1";
    public static final String IC_CONDITION_CODE_FAILED = "2";

    public Field60_2_3()
    {
        fieldName = "IC卡条件代码";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
