package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_7 extends Field {

    public static final String CARD_APP_TYPE_UNKNOWN = "0";  // 未知
    public static final String CARD_APP_TYPE_PBOC = "1"; // PBOC借贷记标准的借贷记应用（含接触式和非接触式）
    public static final String CARD_APP_TYPE_EMV = "2"; // EMV借贷记标准的借贷记应用
    public static final String CARD_APP_TYPE_CASH = "3"; // PBOC借贷记标准的电子现金应用（含接触式和非接触式，其中非接触式应用即qPBOC应用）
    public static final String CARD_APP_TYPE_WALLET = "4"; // PBOC电子钱包应用
    public static final String CARD_APP_TYPE_MSD = "5"; // PBOC借贷记标准的二磁道等效数据应用（即MSD应用）


    public Field60_3_7()
    {
        fieldName = "IC卡的应用类型";
        fieldNo = "60.3.7";


        dataLen = 1;
    }
}
