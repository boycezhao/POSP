package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field53 extends Field {

    public static final String KEY_TYPE_PIK = "1";
    public static final String KEY_TYPE_MAK = "2";

    public static final String PIN_FORMAT_PAN = "1";
    public static final String PIN_FORMAT_NO_PAN = "2";

    public static final String ENCRYPTION_METHOD_SINGLE = "0";
    public static final String ENCRYPTION_METHOD_DOUBLE = "6";

    public static final String RESERVED = "00000000000000";

    public Field53()
    {
        fieldName = "安全控制信息";
        fieldNo = 53;

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 16;
    }
}
