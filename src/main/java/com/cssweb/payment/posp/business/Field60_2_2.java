package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_2 extends Field{

    public static final String TERMINAL_CAP_UNKNOWN = "0";
    public static final String TERMINAL_CAP_MAGNETIC = "2";
    public static final String TERMINAL_CAP_IC = "5";
    public static final String TERMINAL_CAP_ALL = "6";

    public Field60_2_2()
    {
        fieldName = "终端读取能力";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;

    }
}
