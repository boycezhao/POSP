package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_9 extends Field {

    public static final String INTERACTION_TYPE_DEFAULT = "0";
    public static final String INTERACTION_TYPE_INTERNET_SMS = "1"; // 互联网，短信
    public static final String INTERACTION_TYPE_SMS = "2"; // 短信
    public static final String INTERACTION_TYPE_VOICE = "3"; // 语音

    public Field60_2_9()
    {
        fieldName = "交互方式标志，与终端类型配合使用";
        fieldNo = "60.2.9";


        dataLen = 1;
    }
}
