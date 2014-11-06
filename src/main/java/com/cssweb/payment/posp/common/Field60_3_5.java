package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/17.
 */
public class Field60_3_5 extends Field {

    public static final String TRADE_WAY_UNKNOWN = "0"; //该方式用于表示未知支付方式或不关心此交易的具体发起方式下的缺省表示。
    /*
    现场。
该方式用于表示确定的现场支付，指在金融受理终端有人值守，持卡人商户收银员或银行柜面人员面对面、由受理方发起交易的方式，如现场消费、惠农代理点取现，现金充值等交易

     */
    public static final String TRADE_WAY_COUNTER = "1";
    /*
    自助。
各类自助支付，指金融受理终端无人值守，持卡人自主发起交易的方式，包括多媒体终端、电话支付终端等。例如ATM取现、自助存款，互联网、语音、手机支付，基于委托关系的自助支付、自助汇款/存款等交易

     */
    public static final String TRADE_WAY_SELF_SERVICE = "2";
    /*
    代理。
各类代理支付，指持卡人不在现场，商户代为发起。例如代收、代付、订购等交易

     */
    public static final String TRADE_WAY_AGENT = "3";

    public Field60_3_5()
    {
        fieldName = "交易发起方式";
        fieldNo = "60.3.5";


        dataLen = 1;
    }
}
