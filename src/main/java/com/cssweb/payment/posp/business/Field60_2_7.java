package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_7 extends Field {

    // Chip Card Authentication Reliability Indicator
    public static final String IC_AUTH_RELIABILIY_INDICATOR_SUBSEQUENT = "0"; // 第8位或后继位存在时的填充值
    public static final String IC_AUTH_RELIABILIY_INDICATOR_NOT_RELIABLE = "1"; //受理方表示卡的授权可能不可靠
    public static final String IC_AUTH_RELIABILIY_INDICATOR_ACQUIRER = "2"; // 预付卡发卡机构指示受理方未参与卡片的验证
    public static final String IC_AUTH_RELIABILIY_INDICATOR_ISSUER = "3"; // 预付卡发卡机构指示发卡方未参与卡片的验证

    public Field60_2_7()
    {
        fieldName = "芯片卡授权可靠性指示";
        fieldNo = "60.2.7";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
