package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field57_IP extends Field {
    private String amount; // 首期还款金额
    private String cur; // 还款币种
    private String fee; // 持卡人分期付款手续费
    private String scale; // 发卡行与商户签订的分期付款扣率
    private String reserved; // ans50，保留给分期付款方式使用。

    public Field57_IP()
    {
        fieldName = "公共支付信息";
        fieldNo = "57.IP";

        fieldType = FIELD_TYPE_ANSB;

        fieldValueType = FIELD_VALUE_TYPE_LLLV;
        maxFieldLength = 510;
    }
}
