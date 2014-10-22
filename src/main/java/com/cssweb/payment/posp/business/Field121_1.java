package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_1 extends Field{

    public static final String RC_SW_TIMEOUT = "1"; // 预付卡发卡机构计算请求超时，代授权予以响应
    public static final String RC_LOWER_AMOUNT = "2"; // 交易的金额低于发卡方的限制，代授权予以响应
    public static final String RC_ISSUER_BLOCK = "3"; // 发卡方系统交易处理拥塞，代授权予以响应
    public static final String RC_ISSUER_NETWORK_ERROR = "4"; // 发卡方系统无法接受处理，代授权予以响应（连接发卡方的线路出错）
    public static final String RC_ISSUER_RESPONSE = "5"; // 发卡方处理回应
    public static final String RC_ISSUER_CLOSE = "6"; // 发卡方主动退出
    public static final String RC_SW_NOTIFY_IS_EXIT = "7"; // 预付卡发卡机构通知发卡方退出
    public static final String RC_SEND = "A"; // 标识拒绝应答由转出方引起，与应答码联合表示完整的拒绝原因
    public static final String RC_RECV = "B"; // 标识拒绝原因由转入方引起，与应答码联合表示完整的拒绝原因

    public Field121_1()
    {
        fieldName = "应答原因码";
        //fieldNo = "";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;

        isSubField = true;
    }
}
