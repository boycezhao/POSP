package com.cssweb.payment.posp;

/**
 * Created by chenhf on 2014/7/21.
 */
public class Field {
    public static final int FIELD_LENGTH_TYPE_FIXED = 0; // 定长
    public static final int FIELD_LENGTH_TYPE_VAR2 = 2; // 变长2
    public static final int FIELD_LENGTH_TYPE_VAR3 = 3; // 变长3

    protected String fieldName;
    protected int fieldNo;
    protected byte[] fieldValue;
    protected int fieldLengthType = FIELD_LENGTH_TYPE_FIXED;
    protected int fieldLength;



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





    public void setFieldValue(byte[] fieldValue)
    {
        this.fieldValue = fieldValue;
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

    public byte[] getFieldValue()
    {
        if (fieldLengthType == FIELD_LENGTH_TYPE_FIXED)
        {
            return fieldValue.getBytes();
        }
        else if (fieldLengthType == FIELD_LENGTH_TYPE_VAR2)
        {
            // 真实域内容长度
            int actualLen = fieldValue.length();
            String s = String.valueOf(actualLen);
            if (actualLen < 10)
            {
                s = "0" + s;
            }


            // 长度转成字符串，转成字节数组
            byte[] varLen = s.getBytes();

            // 域可变内容
            byte[] actual = fieldValue.getBytes();

            byte[] val = new byte[2 + actualLen];
            System.arraycopy(varLen, 0, val, 0, varLen.length);
            System.arraycopy(actual, 0, val, varLen.length, actual.length);

            return val;
        }
        else if (fieldLengthType == FIELD_LENGTH_TYPE_VAR3)
        {
            // 真实域内容长度
            int actualLen = fieldValue.length();
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
        else
        {
            return null;
        }
    }
}
