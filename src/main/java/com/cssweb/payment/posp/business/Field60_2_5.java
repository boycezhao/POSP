package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_5 extends Field{

    public static final String TERMINAL_TYPE_UNKNOWN = "00";
    public static final String TERMINAL_TYPE_ATM = "01";
    public static final String TERMINAL_TYPE_RESERVED = "02";
    public static final String TERMINAL_TYPE_POS = "03";
   // public static final String TERMINAL_TYPE_RESERVED = "04";
    public static final String TERMINAL_TYPE_MULTIMEIA = "05";
    public static final String TERMINAL_TYPE_COUNTER = "06";
    public static final String TERMINAL_TYPE_PC = "07";
    public static final String TERMINAL_TYPE_MOBILEPHONE = "08";
    public static final String TERMINAL_TYPE_TELEPHONE1 = "09";
    public static final String TERMINAL_TYPE_READER = "10";
    public static final String TERMINAL_TYPE_MOBILE_POS = "11";
    public static final String TERMINAL_TYPE_INTERNET = "12";
    public static final String TERMINAL_TYPE_PEASANT_WORKER = "13";
    public static final String TERMINAL_TYPE_MERCHANT = "14";
    public static final String TERMINAL_TYPE_ORG = "15";
    public static final String TERMINAL_TYPE_SETOP = "16";
    public static final String TERMINAL_TYPE_TELEPHONE2 = "17";
    //public static final String TERMINAL_TYPE_UNKNOWN = "18";
    //public static final String TERMINAL_TYPE_UNKNOWN = "19";



    public Field60_2_5()
    {
        fieldName = "终端类型";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2;
    }
}
