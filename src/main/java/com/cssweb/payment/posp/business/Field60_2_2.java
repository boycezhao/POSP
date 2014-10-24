package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_2 extends Field{

    public static final String TERMINAL_CAP_UNKNOWN = "0"; //终端读取能力不可知
    public static final String TERMINAL_CAP_MAGNETIC = "2"; //只能接触式读取磁条卡
    public static final String TERMINAL_CAP_IC = "5"; //只可采用接触方式读取集成电路（IC）卡，且还可采用接触方式读取磁条卡
    //1）除了有接触式读卡方式以外，还具有非接触式读卡方式。
    //2）除了能读取磁条卡以外，还能读取集成电路（IC）卡或或其它介质类型的卡

    public static final String TERMINAL_CAP_ALL = "6";//

    public Field60_2_2()
    {
        fieldName = "终端读取能力";
        fieldNo = "60.2.2";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;

    }
}
