package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/8/28.
 */
public class ResponseCode {
    public static final String RC_SUCCESS = "00";
    public static final String RC_CONNECT_ISSUER = "01"; // 联系发卡方
    public static final String RC_INVALID_MERCHANT = "03"; // 无效商户
    public static final String RC_CONFISCATE_CARD = "04"; // 没收卡
    public static final String RC_AUTH_ERROR = "05"; // 身份认证失败

    public static final String RC_PART_AMOUNT_ACCEPT = "10"; // 部分金额批准
    public static final String RC_VIP_ACCEPT = "11"; // VIP
    public static final String RC_INVALID_RELATED_TRADE = "12"; // 无效的关联交易
    public static final String RC_IVALID_AMOUNT = "13"; // 无效的金额
    public static final String RC_INVALID_ACCOUNT = "14"; // 无效的卡号或账户

    public static final String RC_CARD_NO_INIT = "21"; // 卡未初始化
    public static final String RC_RELATED_TRADE_ERROR = "22"; // 关联交易错误
    public static final String RC_TRADE_RECORD_NOT_FOUND = "25"; // 找不到原始交易

    public static final String RC_PACKAGE_ERROR = "30"; // 报文格式错误
    public static final String RC_CHEAT = "34"; // 有作弊嫌疑
    public static final String RC_BEYOND_PIN_LIMIT = "38"; // 超过允许的PIN输错次数

    public static final String RC_FUNCTION_NOT_SUPPORT = "40"; //请求的功能不支持
    public static final String RC_CARD_LOSS = "41"; // 挂失卡
    public static final String RC_CARD_STEAL = "43"; // 被窃卡

    public static final String RC_BALANCE_NOT_ENOUGH = "51"; // 余额不足
    public static final String RC_CARD_EXPIRE = "54"; // 过期的卡
    public static final String RC_PIN_ERROR = "55"; // 不正确的PIN
    public static final String RC__NOT_ACCESS = "57"; // 不允许持卡人进行的交易
    public static final String RC_TERMINAL_NOT_ACCESS = "58"; // 不允许终端进行的交易
    public static final String RC_CVN_ERROR = "59"; // CVN验证失败

    public static final String RC_BEYOND_AMOUNT_LIMIT = "61"; // 超出金额限制
    public static final String RC_CARD_LIMIT = "62"; // 受限制的卡
    public static final String RC_AMOUNT_ERROR = "64"; // 金额错误
    public static final String RC_BEYOND_TRADE_TIMES = "65"; // 超出取款、消费次数限制
    public static final String RC_RESPONSE_TIMEOUT = "68"; // 发卡方响应超时

    public static final String RC_BEYOND_PIN_TIMES = "75"; // 超过PIN输错次数

    public static final String RC_DAY_CLEARING = "90"; // 日终处理
    public static final String RC_ISSUER_NOT_ACCESS = "91"; // 发卡方不能操作
    public static final String RC_NETWORD_ERROR = "92"; // 网络错误
    public static final String RC_REPEAT_TRADE = "94"; // 重复交易
    public static final String RC_PIN_FORMAT_ERROR = "99"; // PIN格式错误

    public static final String RC_MAC_ERROR = "A0"; // MAC校验失败
    public static final String RC_CUR_NOT_SAME = "A1"; // 转账货币不一致
    public static final String RC_ACCOUNT_NOT_EXIST = "A3"; // 资金到账行无此账户
    //public static final String RC_CUR_NOT_SAME = "A4"; // 有缺陷的成功
    //public static final String RC_CUR_NOT_SAME = "A5"; // 有缺陷的成功
    public static final String RC_SECURITY_ERROR = "A7"; // 安全处理失败

    public static final String RC_ORGCODE_ERROR = "D1"; // 机构代码错误
    public static final String RC_DATE_ERROR = "D2"; // 日期错误
    public static final String RC_FILE_INVALID_TYPE = "D3"; // 无效的文件类型
    public static final String RC_FILE_EXIST = "D4"; // 已处理过文件
    public static final String RC_FILE_NOT_FOUND = "D5"; // 无此文件
    public static final String RC_FILE_NOT_SUPPORT = "D6"; // 接收者不支持
    public static final String RC_FILE_LOCK = "D7"; // 文件锁定
    public static final String RC_FILE_ERROR = "D8"; // 未成功
    public static final String RC_FILE_LENGTH_ERROR = "D9"; // 文件长度不符
    public static final String RC_FILE_COMPRESS_ERROR = "DA"; // 压缩错误
    public static final String RC_FILE_NAME_ERROR = "DB"; // 文件名错误
    public static final String RC_FILE_RECEIVE_ERROR = "DC"; // 接收失败



    //public static final String RC_VIP = "N1"; // 未登折账目已超限
}
