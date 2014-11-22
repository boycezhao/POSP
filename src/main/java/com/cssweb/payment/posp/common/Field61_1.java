package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field61_1 extends Field {

    public static final String IDTYPE_ID = "01";  // 身份证
    public static final String IDTYPE_ARMY = "02";// 军官证
    public static final String IDTYPE_PASSPORT = "03";// 护照
    public static final String IDTYPE_RETURN = "04";// 回乡证
    public static final String IDTYPE_TAIWAN = "05";// 台胞证
    public static final String IDTYPE_POLICE = "06";// 警官证
    public static final String IDTYPE_SOLIDER = "07";// 士兵证
    public static final String IDTYPE_OTHER = "99";// 其它证件证件编号不足20位后补空格

    public Field61_1()
    {
        fieldName = "证件编号";
        fieldNo = "61.1";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_DEFAULT;
        dataLen = 22;


    }
}
