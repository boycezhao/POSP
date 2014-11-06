package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field61_6_AR extends Field {

    private String serialNo; // SR流水号
    private String verificationTime; //验证服务时间
    private String result; //发卡机构认证结果

    public Field61_6_AR()
    {
        fieldName = "银联安全输入模式下发卡机构的认证结果";
        fieldNo = "61.6.AR";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 26;


    }
}
