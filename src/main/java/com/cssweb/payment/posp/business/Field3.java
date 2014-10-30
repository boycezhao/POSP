package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field3  extends Field {

    public static final String TRD_TYPE_DEBIT = "19"; // 借记
    public static final String TRD_TYPE_GOODS_SERVICE = "00"; //商品和服务
    public static final String TRD_TYPE_CASH = "01"; //现金
    public static final String TRD_TYPE_ADJUSTMENT = "02"; //调整
    public static final String TRD_TYPE_CHEQUE_GUARANTEE = "03"; //支票担保（资金可担保）
    public static final String TRD_TYPE_CHEQUE_VERIFICATION = "04"; //支票核实（资金可用但不担保）
    public static final String TRD_TYPE_EURO_CHEQUE = "05"; //欧洲支票
    public static final String TRD_TYPE_TRAVELER_CHEQUE = "06"; //旅行支票
    public static final String TRD_TYPE_LETTER = "07"; //信用证
    public static final String TRD_TYPE_GIRO = "08"; //直接转账（邮政银行业务）
    public static final String TRD_TYPE_GOODS_SERVICE_WITH_CASH = "09"; //现金支付的商品和服务
    public static final String TRD_TYPE_CREDIT = "29"; //贷记
    public static final String TRD_TYPE_RETURN = "20"; //退款
    public static final String TRD_TYPE_DEPOSIT = "21"; //存款
  //  public static final String TRD_TYPE_ADJUSTMENT = "22"; //调整
    public static final String TRD_TYPE_CHEQUE_DEPOSIT_GUARANTEE = "23"; //支票存款担保
    public static final String TRD_TYPE_CHEQUE_DEPOSIT = "24"; //支票存款
    public static final String TRD_TYPE_QUERY_SERVICE = "30"; //查询服务
    public static final String TRD_TYPE_AVAILABLE_FUND_QUERY = "30"; //可用金额查询
    public static final String TRD_TYPE_BALANCE_QUERY = "31"; //余额查询
    public static final String TRD_TYPE_TRANSFER_SERVICE = "49"; //转账服务
    public static final String TRD_TYPE_CARDHOLDER_ACCOUNT_TRANSFER = "40"; //持卡人账户转账
    public static final String TRD_TYPE_PIN_CHANGE = "70"; //修改密码




    public static final String FROM_DEFAULT = "0";
    public static final String FROM_DEPOSIT = "1";
    public static final String FROM_CHEQUE = "2";
    public static final String FROM_CREDIT = "3";
    public static final String FROM_COMMON = "4";
    public static final String FROM_INVESTMENT = "5";


    public static final String TO_DEFAULT = "0";

    private String tradeType; //交易类型
    private String from; //表示转出(From)账户类型
    private String to; //表示转入(To)账户类型

    public String getTradeType() {
        return tradeType;
    }



    public String getFrom() {
        return from;
    }



    public String getTo() {
        return to;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
        System.arraycopy(tradeType.getBytes(), 0, fieldValue, 0, tradeType.getBytes().length);
    }
    public void setFrom(String from) {

        this.from = from;
        System.arraycopy(from.getBytes(), 0, fieldValue, 2, from.getBytes().length);
    }
    public void setTo(String to) {
        this.to = to;
        System.arraycopy(to.getBytes(), 0, fieldValue, 4, to.getBytes().length);
    }

    public Field3()

    {
        fieldName = "交易处理码";
        fieldNo = "3";

        fieldType = FIELD_TYPE_N;

        fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
        fieldLength = 6;

        //fieldValue = new byte[fieldLength];
    }
}
