package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_5 extends Field {

    public static final String TERMINAL_TYPE_UNKNOWN = "00"; //未知
    public static final String TERMINAL_TYPE_ATM = "01"; //自动柜员机（含ATM和CDM）
    public static final String TERMINAL_TYPE_RESERVED = "02"; //保留使用
    public static final String TERMINAL_TYPE_POS = "03"; //有线销售点终端（POS）
   // public static final String TERMINAL_TYPE_RESERVED = "04";
    public static final String TERMINAL_TYPE_MULTIMEIA = "05"; //多媒体终端
    public static final String TERMINAL_TYPE_COUNTER = "06"; //银行柜台和柜面
    public static final String TERMINAL_TYPE_PC = "07"; //个人电脑
    public static final String TERMINAL_TYPE_MOBILEPHONE = "08"; //手机设备
    public static final String TERMINAL_TYPE_TELEPHONE1 = "09"; //I型固定电话
    public static final String TERMINAL_TYPE_READER = "10"; //基于PBOC电子钱包/存折标准的交易终端
    public static final String TERMINAL_TYPE_MOBILE_POS = "11"; //无线销售点终端（移动POS）
    public static final String TERMINAL_TYPE_INTERNET = "12"; //中国银联公共服务平台
    public static final String TERMINAL_TYPE_PEASANT_WORKER = "13"; //农民工银行卡特色服务
    public static final String TERMINAL_TYPE_MERCHANT = "14"; //商户系统
    public static final String TERMINAL_TYPE_ORG = "15"; //第三方机构系统（目前主要是渠道接入机构）
    public static final String TERMINAL_TYPE_SETOP = "16"; //数字机顶盒
    public static final String TERMINAL_TYPE_TELEPHONE2 = "17";//II型固定电话
    //public static final String TERMINAL_TYPE_UNKNOWN = "18";
    //public static final String TERMINAL_TYPE_UNKNOWN = "19";



    public Field60_2_5()
    {
        fieldName = "终端类型";
        fieldNo = "60.2.5";


        dataLen = 2;


    }
}
