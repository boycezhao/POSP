package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field61_6_SA extends Field{

    private String sequenceNo;//            SR流水号
    private String verificationTime; //验证服务时间
    private String logisticsDistribution; // 物流配送标志
    private String subMerchantCode; //子商户代码

    private String cavvAlgo; // CAVV算法标识

    private String unknown; // 表明ATN（验证跟踪号）的最低四位
    private String atn;//ATN （验证跟踪号）
    private String reserved; // 保留

    public Field61_6_SA()
    {
        fieldName = "发卡机构直接身份认证模式";
        fieldNo = "61.6.SA";

        fieldType = FIELD_TYPE_ANS;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 60;

        isSubField = true;
    }
}
