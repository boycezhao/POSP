package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_3 extends Field {

    public static final String IC_CONDITION_CODE_UNKNOWN = "0"; //未使用或后续子域存在
    /*
    终端对卡片的上一次读取动作发现不是IC卡交易或者发现是一笔成功的IC卡交易。
填1，表示不插卡，直接刷卡时，IC卡交易为降级处理，同时当1大量存在的话，表示商户操作不规范，有更大的欺诈嫌疑。

     */
    public static final String IC_CONDITION_CODE_SUCCESS = "1";
    /*
    终端对卡片的上一次读取动作发现交易虽是IC卡交易但失败。例如，持卡人拿IC卡来做交易，但插IC卡以后，终端无法读取应用，改为刷卡，那么这笔刷卡交易对应的上一次读取，就是开始读IC卡芯片失败的那次读取，因为IC卡芯片读取失败，所以是一个失败的IC卡交易，此时该域应该填2
填2，表示当终端或卡片有问题时，IC卡交易为降级处理，同时当2大量存在的话，也表示商户可能有欺诈嫌疑

     */
    public static final String IC_CONDITION_CODE_FAILED = "2";

    public Field60_2_3()
    {
        fieldName = "IC卡条件代码";
        fieldNo = "60.2.3";


        dataLen = 1;
    }
}
