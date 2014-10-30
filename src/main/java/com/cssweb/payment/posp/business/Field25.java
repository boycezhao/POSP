package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field25  extends Field {

    public static final String COMMIT = "00"; //正常提交
    public static final String NOT_COMMIT = "01"; //客户不提交
    public static final String NON_EXT_TERMINAL = "02"; //非扩展终端
    public static final String SUSPICIOUS_MERCHANT = "03"; //可疑商户
    public static final String COMMIT_NOT_CARD = "05"; //客户提交但卡不提交
    public static final String PREAUTH = "06"; //预授权请求
    public static final String AUTH = "08"; //授权、消费（专用于MOTO业务）
    public static final String CLIENT_ID = "10"; //确认的客户标识
    public static final String CHEAT = "11"; //作弊嫌疑
    public static final String SECURITY_REASON = "12"; //安全原因
    public static final String REPRESENTMENT = "13"; //再请款
    public static final String CHARGEBACK = "17"; //退单
    public static final String MOTO = "18"; //MOTO预授权类
    public static final String COLLECT = "28"; //代收类
    public static final String SECOND_CHARGEBACK = "41"; //二次退单
    public static final String EB_COMMIT = "42"; //电子商务交易的正常提交
    public static final String EB_PREAUTH = "43"; //电子商务交易的预授权请求
    public static final String EB_REPRESENTMENT = "44"; //电子商务交易的再请款
    public static final String EB_CHARGEBACK = "45"; //电子商务交易的退单
    public static final String RESERVED = "60"; //保留使用
    public static final String INSTALLMENT = "64"; //采取分期付款方式完成支付
    public static final String BONUS_POINT = "65"; //采取积分兑换方式完成支付
    public static final String TRANSFER = "66"; //转入方付费的转账
    //private static final String COMMIT = "68"; //保留使用
    public static final String EXCEPTION = "82"; //差错例外
    public static final String CREDIT_ADJUSTMENT = "83"; //转入方提出的贷记调整、发卡方提出的存款的贷记调整
    public static final String LOAD_TRADE = "91"; //基于PBOC电子钱包/存折标准和IC卡电子现金应用的圈存类交易


    public Field25()
    {
        fieldName = "服务点条件码";
        fieldNo = "25";

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 2;
    }
}
