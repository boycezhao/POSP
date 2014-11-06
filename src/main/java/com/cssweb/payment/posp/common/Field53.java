package com.cssweb.payment.posp.common;

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


    private String pinFormat;
    private String encAlgo;



    public static String getKeyTypePik() {
        return KEY_TYPE_PIK;
    }

    public String getEncAlgo() {
        return encAlgo;
    }



    public String getPinFormat() {
        return pinFormat;
    }

    public void setPinFormat(String pinFormat) {
        this.pinFormat = pinFormat;
        System.arraycopy(pinFormat.getBytes(), 0, fieldValue, 0, pinFormat.getBytes().length);
    }
    public void setEncAlgo(String encAlgo) {
        this.encAlgo = encAlgo;
        System.arraycopy(encAlgo.getBytes(), 0, fieldValue, 1, encAlgo.getBytes().length);
    }

    public Field53()
    {
        fieldName = "安全控制信息";
        fieldNo = "53";

        fieldType = FIELD_TYPE_N;


        dataLen = 16;
/*
        fieldValue = new byte[fieldLength];
        for (int i=0; i<fieldLength; i++)
        {
            fieldValue[i] = '0';
        }
        */
    }
}
