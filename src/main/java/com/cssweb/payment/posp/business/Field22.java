package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field22 extends Field{
    public static final String PAN_UNKNOW = "00";
    public static final String PAN_MAGNETIC = "01";//手工
    public static final String PAN_MANUAL = "02";//接触式读取磁条
    public static final String PAN_BARCODE = "03";//条形码
    public static final String PAN_OCR = "04";//光学字符阅读
    public static final String PAN_IC = "05";//接触式读取集成电路（IC）卡，且信息可靠
    public static final String PAN_QPBOC = "07";//非接触式读取集成电路（IC）卡，且为qPBOC应用
    public static final String PAN_MAGNETIC_ = "90";//接触式读取磁条，且读入信息可靠，第二磁道信息必须出现
    public static final String PAN_MSD = "91";//非接触式读取集成电路（IC）卡中的磁条信息（即MSD应用）
    public static final String PAN_IC_UNRELIABLE = "95";//接触式读取集成电路（IC）卡，且信息不可靠
    public static final String PAN_PBOC = "98";  //非接触式读取集成电路（IC）卡，且为PBOC借贷记应用

    public static final String PIN_UNKNOWN  = "0";
    public static final String PIN_INCLUDE  = "1"; //交易中包含PIN
    public static final String PIN_NOT_INCLUDE  = "2";//交易中不包含PIN


    public Field22()
    {
        fieldName = "服务点接入方式码";
        fieldNo = 22;

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 3;
    }

}
