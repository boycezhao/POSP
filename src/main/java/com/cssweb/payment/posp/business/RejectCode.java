package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/8/28.
 */
public class RejectCode {

    // 第一位说明，
    public static final String ERROR_KIND_HEADER = "0";  // 指消息头错误
    public static final String ERROR_KIND_CONTENT = "1"; // 指消息内容错误
    public static final String ERROR_KIND_UNION = "2"; // 指银联中心错误

    // 第五位说明， 即错误类型
    public static final String ERROR_TYPE_LEN_ERROR = "1"; // 长度错误
    public static final String ERROR_TYPE_BITMAP_ = "2"; // bitmap非法
    public static final String ERROR_TYPE_NOT_DIGITAL = "3"; // 长度域中出现非法字符
    public static final String ERROR_TYPE_LEN_OVERFLOW = "4"; // 超出最大长度值
    public static final String ERROR_TYPE_ILLEGAL_CHAR = "5"; // 出现非法字符
    public static final String ERROR_TYPE_NO_REQUIRED_FIELD = "6"; // 缺少必要的域

    public static final String RC_HEADER_LEN_ERROR = "00015";
    public static final String RC_HEADER_VER_ERROR = "00025";
    public static final String RC_HEADER_TOTAL_LEN_ERROR = "00035";
    public static final String RC_HEADER_DESTID_ERROR = "00045";
    public static final String RC_HEADER_SRCID_ERROR = "00055";
    public static final String RC_HEADER_RESERVED_ERROR = "00065";
    public static final String RC_HEADER_BATCH_ERROR = "00075";
    public static final String RC_HEADER_UNION_ERROR = "00085";

    /**
     * 错误类别是0或1, 后面3位是出错域号，最后一位是错误类型
     * 错误类型是2， 后面4位是出错原因
     * @param errKind
     * @param fieldNo
     * @param errType
     * @return
     */
    public static String getRejectCode(String errKind, String fieldNo, String errType)
    {
        // fieldNo必须为3位数字字符，不足3位，前面补0
        String str ="000";
        String val  = str.substring(0, str.length() - fieldNo.length()) + fieldNo;

        String rejectCode = errKind + val + errType;

        return rejectCode;
    }
}
