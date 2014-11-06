package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_8 extends Field {

    public static final String ECI_UNKNOWN = "00"; //未使用或后续子域存在
    public static final String ECI_UNION = "01"; //进行了银联安全输入模式认证，且持卡人安全信息输入成功
    public static final String ECI_ISSUER_SAA = "03"; //进行了发卡机构SAA直接验证授权模式认证，且SAA验证授权成功
    public static final String ECI_ISSUER_SA = "05"; //进行了发卡机构SA直接身份认证模式认证，且持卡人身份验证成功
    public static final String ECI_TRY_ISSUER = "06"; // 曾尝试进行发卡机构直接身份验证模式认证
    public static final String ECI_ECURE_STUNNEL = "07"; //未通过预付卡发卡机构ecure安全认证，但采用了信道加密等安全技术
    public static final String ECI_ECURE = "08";//未通过预付卡发卡机构ecure安全认证，且未采用信道加密等安全技术

    public Field60_2_8()
    {
        fieldName = "电子商务标识（ECI）";
        fieldNo = "60.2.8";


        dataLen = 2;



    }
}
