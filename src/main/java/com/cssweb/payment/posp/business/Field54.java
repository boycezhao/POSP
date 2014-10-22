package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field54 extends Field {

    public static final String ACC_TYPE_DEPOSIT = "10";
    public static final String ACC_TYPE_CHECK = "20";
    public static final String ACC_TYPE_CREDIT = "30";
    public static final String ACC_TYPE_BONUS_POINT = "90";

    public static final String BALANCE_TYPE_LEDGER = "01";
    public static final String BALANCE_TYPE_AVAILABLE = "02";

    public static final String CUR_CODE_RMB = "156";

    public static final String BALANCE_DIR_DEBIT = "D";
    public static final String BALANCE_DIR_CREDIT = "C";

    public Field54()
    {
        fieldName = "实际余额";
        fieldNo = 54;

        fieldType = FIELD_TYPE_AN;

        fieldLengthType = FIELD_LENGTH_TYPE_VAR3;
        maxFieldLength = 40;
    }
}
