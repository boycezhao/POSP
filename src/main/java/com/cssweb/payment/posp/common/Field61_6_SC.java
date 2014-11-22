package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field61_6_SC extends Field {

    private String sequenceNo;//SR流水号
    private String verificationTime; // 验证服务时间
    private String logisticsDistribution;//物流配送标志
    private String subMerchantCode; // 子商户代码
    private String verificationMehtod; //验证方式
    private String result; // 代理认证证书结果
    private String payPassword; // 互联网支付密码
    private String name;
    private String birthday;
    private String issuingDate; // 发卡日期
    private String reserved; // 保留的其他认证信息Ans40

    public Field61_6_SC()
    {
        fieldName = "银联安全输入模式";
        fieldNo = "61.6.SC";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_TV;
        dataLen = 6 + 19 + 1 + 8 + 1 + 1 + 192/8 + 20 + 8 + 40;


    }
}
