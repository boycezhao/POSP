package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_2_1 extends Field{

    public static final String ACCOUNT_TYPE_PERSONAL_CARD = "0"; // 个人卡帐户
    public static final String ACCOUNT_TYPE_PERSONAL = "1"; //个人非卡帐户
    public static final String ACCOUNT_TYPE_ENTERPRISE = "2"; //对公非卡账户
    public static final String ACCOUNT_TYPE_ENTERPRISE_CARD = "3"; //对公卡账户
    public static final String ACCOUNT_TYPE_UNKNOWN = "9"; //未知或与账户所有人类型无关
    public static final String ACCOUNT_TYPE_COUPON = "A"; //个人银联联盟积分账户


    public Field60_2_1()
    {
        fieldName = "账户所有人类型";
        fieldNo = "60.2.1";

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 1;
    }
}
