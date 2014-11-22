package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/24.
 */
public class Field61_6_AM_1 extends Field {

    private byte password;//密码验证
    private byte cardExpire;//卡有效期验证
    private byte id; //身份证验证
    private byte magnetic; //磁道信息验证
    private byte trustRelationship; //委托关系验证
    private byte cvn; //CVN（CVN2）验证
    private byte pvn;//PVN验证
    private byte name;//姓名验证
    private byte reserved;//保留使用，用全零填充

    private String data; // 业务自定义数据ans…153。根据受理方的各业务需求自行填写

    public Field61_6_AM_1()
    {
        fieldName = "受理方要求发卡方校验的方式";
        fieldNo = "61.6.AM";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_TV;
        dataLen = 10;

        //ans…153。根据受理方的各业务需求自行填写

    }
}
