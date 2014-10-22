package com.cssweb.payment.posp.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhf on 2014/7/21.
 */
public class Field {
    private static final Logger logger = LogManager.getLogger(Field.class.getName());
    // 域描述
    protected String fieldName;

    // 域编号
    protected int fieldNo;

    // 数据类型
    protected String fieldType;
    public static final String FIELD_TYPE_BINARY_BIT = "b";
    public static final String FIELD_TYPE_BINARY_BYTE = "B";
    public static final String FIELD_TYPE_ANS = "ans";
    public static final String FIELD_TYPE_N = "n";
    public static final String FIELD_TYPE_Z = "Z";
    public static final String FIELD_TYPE_AN = "an";
    public static final String FIELD_TYPE_ANSB = "ansb";

    // 长度类型
    public static final int FIELD_LENGTH_TYPE_FIXED = 0; // 定长
    public static final int FIELD_LENGTH_TYPE_VAR2 = 2; // 变长2
    public static final int FIELD_LENGTH_TYPE_VAR3 = 3; // 变长3
    protected int fieldLengthType = FIELD_LENGTH_TYPE_FIXED;


    // 长度
    protected int fieldLength;
    protected int maxFieldLength; // 最大长度

    // 域值
    protected byte[] fieldValue;

    // 子域相关处理
    protected boolean isSubField = false; // 是否是子域
    protected boolean hasSubField = false; // 是否有子域
    protected List<Field> subFields = new ArrayList<Field>();
    public void addField(Field subField)
    {
        subFields.add(subField);
        hasSubField = true;
    }
    protected int beginPos = 0; // 相对于父域的开始位置




    public int getFieldLengthType() {
        return fieldLengthType;
    }
    public void setFieldLengthType(int fieldLengthType) {
        this.fieldLengthType = fieldLengthType;
    }

    public int getFieldLength() {
            return fieldLength;
    }
    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldNo() {
        return fieldNo;
    }
    public void setFieldNo(int fieldNo) {
        this.fieldNo = fieldNo;
    }


    public void setFieldValue(byte[] fieldValue)
    {
        this.fieldValue = fieldValue;
    }
    public void setFieldValue(String fieldValue) {this.fieldValue = fieldValue.getBytes(); }
    public byte[] getFieldValue()
    {
        if (fieldLengthType == FIELD_LENGTH_TYPE_FIXED)
        {
            return fieldValue;
        }
        else if (fieldLengthType == FIELD_LENGTH_TYPE_VAR2)
        {
            // 真实域内容长度
            int actualLen = fieldValue.length;
            String s = String.valueOf(actualLen);
            if (actualLen < 10)
            {
                // 长度左边补0
                s = "0" + s;
            }


            // 长度转成字符串，转成字节数组
            byte[] varLen = s.getBytes(); // 例如："09"



            byte[] val = new byte[2 + actualLen];
            System.arraycopy(varLen, 0, val, 0, varLen.length);
            System.arraycopy(fieldValue, 0, val, varLen.length, fieldValue.length);

            return val;
        }
        /*
        else if (fieldLengthType == FIELD_LENGTH_TYPE_VAR3)
        {

            // 真实域内容长度
            int actualLen = fieldValue.length;
            //if (actualLen > 2)
            {
                //throw;
            }

            // 长度转成字符串，转成字节数组
            byte[] varLen = String.valueOf(actualLen).getBytes();

            // 域可变内容
            byte[] actual = fieldValue.getBytes();

            byte[] val = new byte[3 + actualLen];
            System.arraycopy(varLen, 0, val, 0, varLen.length);
            System.arraycopy(actual, 0, val, varLen.length, actual.length);

            return val;
        }
        */
        else
        {
            return null;
        }
    }

    /**
     * 验证数据格式
     * @return
     */
    public boolean validate()
    {
        // 用正则表达式验证数据格式
        // 返回RejectCode
        return true;
    }
}
