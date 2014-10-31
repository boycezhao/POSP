package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field61_6_CR extends Field {

    private String CAVV_UNKNOWN = "0"; // 未校验CAVV
    private String CAVV_SA_FAIL = "1"; // CAVV校验失败——针对成功进行SA模式认证方式（60.2.8域必须填写05）
    private String CAVV_SA_SUCCESS = "2"; // CAVV校验成功——针对成功进行SA模式认证方式（60.2.8域必须填写05）
    private String CAVV_TRY_SA_SUCCESS = "3"; // CAVV校验成功——针对尝试进行SA模式认证方式（60.2.8域必须填写06）
    private String CAVV_TRY_SA_FAIL = "4"; // CAVV校验失败——针对尝试进行SA模式认证方式（60.2.8域必须填写06）
    private String CAVV_RESERVED = "5"; // 保留使用

    public Field61_6_CR()
    {
        fieldName = "发卡机构直接身份认证模式下发卡机构对CAVV值的认证结果";
        fieldNo = "61.6.CR";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 1;


    }
}
