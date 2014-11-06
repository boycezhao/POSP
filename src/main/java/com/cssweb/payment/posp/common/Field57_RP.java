package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field57_RP extends Field {
    private String scores; //n10，由发卡方填写（必填），右对齐左补零，无小数位。若无兑换积分，则本字段以全零填充
    private String amount; //n12，由发卡方填写，右对齐左补零。若无自付金则本字段以全零填充
    private String reserved; // ans50，保留给积分兑换方式使用

    public Field57_RP()
    {
        fieldName = "6.44.7.1.4　积分兑换信息";
        fieldNo = "57.RP";

        fieldType = FIELD_TYPE_N;


        dataLen = 72;


    }
}
