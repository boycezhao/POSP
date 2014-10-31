package com.cssweb.payment.posp.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenhf on 2014/7/21.
 */
public class Field {
    private static final Logger logger = LogManager.getLogger(Field.class.getName());

    // 域的数据类型
    public static final String FIELD_TYPE_BINARY_BIT = "b";
    public static final String FIELD_TYPE_BINARY_BYTE = "B";
    public static final String FIELD_TYPE_ANS = "ans";
    public static final String FIELD_TYPE_N = "n";
    public static final String FIELD_TYPE_Z = "Z";
    public static final String FIELD_TYPE_AN = "an";
    public static final String FIELD_TYPE_ANSB = "ansb";

    // 长度类型
    //public static final int FIELD_LENGTH_TYPE_FIXED = 0; // 定长
    //public static final int FIELD_LENGTH_TYPE_VAR2 = 2; // 变长2
    //public static final int FIELD_LENGTH_TYPE_VAR3 = 3; // 变长3

    /*
        1.数据
        2.2字节长度+数据
        3.3字节长度+数据
        4.tag+数据
        5.tag+2字节长度+数据
        6.tag+3字节长度+数据
         */
    //域的值构成类型
    protected static final int FIELD_VALUE_TYPE_DEFAULT = 1;
    protected static final int FIELD_VALUE_TYPE_LLV = 2;
    protected static final int FIELD_VALUE_TYPE_LLLV = 3;
    protected static final int FIELD_VALUE_TYPE_TV = 4;
    protected static final int FIELD_VALUE_TYPE_TLLV = 5;
    protected static final int FIELD_VALUE_TYPE_TLLLV = 6;


    // 域描述
    protected String fieldName = "";

    // 域编号
    protected String fieldNo = "";

    // 数据类型
    protected String fieldType = "";





    protected int fieldValueType = FIELD_VALUE_TYPE_DEFAULT;

    protected byte[] data = null; //真正的数据

    protected int dataLen = 0;
    // 最大数据长度
    protected int maxFieldLength = 0;

    // 子域当前标志名称
    protected String tag = "";
    //如果是父域代表当前设置的是哪一个子域
    protected String currentTag = "";

    // 长度，fieldValue的长度
    protected int fieldLength = 0;
    // 完整的域值包括tag，
    protected byte[] fieldValue = null;

    // 相对于父域的开始位置
    protected int beginPos = 0;






    public Field()
    {
        /*
        if (fieldLengthType == FIELD_LENGTH_TYPE_FIXED)
        {
            fieldValue = new byte[fieldLength];
        }
        else
        {
            fieldValue = new byte[maxFieldLength];
        }
        */
    }



    public int getFieldValueType() {
        return fieldValueType;
    }
    public void setFieldValueType(int fieldValueType) {
        this.fieldValueType = fieldValueType;
    }




    public int getMaxFieldLength() {
        return maxFieldLength;
    }
    public void setMaxFieldLength(int maxFieldLength) {
        this.maxFieldLength = maxFieldLength;
    }

    public String getFieldType() {
        return fieldType;
    }
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }



    public int getFieldLength() {
        return fieldLength;
    }
    public void setFieldLength(int fieldLength) {


        if (fieldLengthType == FIELD_LENGTH_TYPE_VAR2)
        {
            this.fieldLength = 2 + fieldLength;
        }
        else if (fieldLengthType == FIELD_LENGTH_TYPE_VAR3)
        {
            this.fieldLength = 3 + fieldLength;
        }
        else
        {
            this.fieldLength = fieldLength;
        }

        fieldValue = new byte[fieldLength];
    }

    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldNo() {
        return fieldNo;
    }
    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo;
    }


    public String getCurrentTag() {
        return currentTag;
    }
    public void setCurrentTag(String currentTag) {
        this.currentTag = currentTag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag()
    {
        return tag;
    }



    public int getBeginPos() {
        return beginPos;
    }
    public void setBeginPos(int beginPos) {
        this.beginPos = beginPos;
    }

    public Map<String, Field> getFields() {
        return fields;
    }
    public void setFields(Map<String, Field> fields) {
        this.fields = fields;
    }

    /**
     *
     * @param data
     */
    public void setFieldValue(byte[] data) throws FieldLengthException, OverflowMaxLengthException {
        if (fieldValueType == FIELD_VALUE_TYPE_DEFAULT)
        {


            if (fieldLengthType == FIELD_LENGTH_TYPE_FIXED)
            {
                if (data.length < fieldLength)
                    throw new FieldLengthException(this);

                if (data.length > fieldLength)
                    throw new OverflowMaxLengthException(this);

                //fieldValue = new byte[fieldLength];
                this.fieldValue = data;

                // 如果是数值型，那么前补0
                if (fieldType == FIELD_TYPE_N)
                {

                }
                else if (fieldType == FIELD_TYPE_AN || fieldType == FIELD_TYPE_ANS || fieldType == FIELD_TYPE_ANSB)
                {

                }
                // 如果是字符型，那后后补space
            }
            else if(fieldLengthType == FIELD_LENGTH_TYPE_VAR2)
            {

                //前面2字节表示长度
                int len = data.length;
               if ( (len+2) > maxFieldLength )
                    throw new OverflowMaxLengthException(this);

                fieldLength = 2 + data.length;
                fieldValue = new byte[fieldLength];

                String lenStr = String.valueOf(len);
                if (lenStr.length() < 2)
                    lenStr = "0" + lenStr;

                System.arraycopy(lenStr.getBytes(), 0, fieldValue, 0, 2);
                System.arraycopy(data, 0, fieldValue, 2, data.length);



            }
            else if(fieldLengthType == FIELD_LENGTH_TYPE_VAR3)
            {
                //前面3字节表示长度
            }
            else
            {
              //  throw Exception;
            }



        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TL)
        {
            int tagLen = tag.getBytes().length;

            fieldValue = new byte[tagLen + valueLen]; //tag所占字节长度+数据长度

            System.arraycopy(tag.getBytes(), 0, this.fieldValue, 0, tagLen);
            System.arraycopy(data, 0, this.fieldValue, tagLen, data.length);
        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TLV)
        {

        }
        else
        {
            //throw exception
        }
    }

    /**
     *
     * @param data
     */
    public void setFieldValue(String data) throws FieldLengthException, OverflowMaxLengthException {
        setFieldValue(data.getBytes());
    }

    /**
     *
     * @param subField
     * @throws FieldLengthException
     * @throws OverflowMaxLengthException
     */
    public void setFieldValue(Field subField) throws FieldLengthException, OverflowMaxLengthException {
        setFieldValue(subField.getFieldValue());
    }

    /**
     *
     * @return
     */
    public byte[] getFieldValue()
    {
        return fieldValue;
        /*
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

        else
        {
            return null;
        }
        */
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




    /**
     *
     * @return
     */
    public String toString()
    {

        String s = fieldNo + "(" + fieldName + ")：" + new String(fieldValue) + "; 实际长度：" + fieldLength;

        return s;
    }

    /**
     *
     * @param field
     */
    public void addField(Field field)
    {
        System.arraycopy(field.getFieldValue(), 0, fieldValue, field.getBeginPos(), field.getFieldLength());

        fields.put(field.getFieldName(), field);


    }

    /**
     * 字符串后补空格
     * @param val 字符串
     * @param totalLen 总长度
     * @return 返回后补空格后字符串
     */
    public String appendSpace(String val, int totalLen)
    {
        int valLen = val.getBytes().length;
        if (valLen >= totalLen)
            return val;

        StringBuffer sb = new StringBuffer();
        sb.append(val);

        for (int i=0; i < totalLen - valLen; i++)
        {
            sb.append(" ");
        }

        return sb.toString();
    }

    /**
     *
     * @param val
     * @param totalLen
     * @return
     */
    public String insertZero(String val, int totalLen)
    {
        return "";
    }

    /**
     *
     * @param fieldData
     * @param srcPos
     */
    public int decode(byte[] fieldData, int srcPos)
    {
        int nextPos = 0;

        if (fieldLengthType == FIELD_LENGTH_TYPE_FIXED) {
            fieldValue = new byte[fieldLength];

            System.arraycopy(fieldData, srcPos, fieldValue, 0, fieldLength);

            nextPos =  srcPos + fieldLength;
        }
        else if (fieldLengthType == FIELD_LENGTH_TYPE_VAR2)
        {
            byte[] varLen = new byte[Field.FIELD_LENGTH_TYPE_VAR2];
            System.arraycopy(fieldData, srcPos, varLen, 0, varLen.length);
            int fieldLen = Integer.parseInt(new String(varLen));

            fieldLength = Field.FIELD_LENGTH_TYPE_VAR2 + fieldLen;

            fieldValue = new byte[fieldLength];

            System.arraycopy(fieldData, srcPos, fieldValue, 0, fieldLength);

            nextPos =  srcPos + fieldLength;
        }
        else if(fieldLengthType == FIELD_LENGTH_TYPE_VAR3)
        {
            byte[] varLen = new byte[Field.FIELD_LENGTH_TYPE_VAR3];
            System.arraycopy(fieldData, srcPos, varLen, 0, varLen.length);
            int fieldLen = Integer.parseInt(new String(varLen));

            fieldLength = Field.FIELD_LENGTH_TYPE_VAR3 + fieldLen;

            fieldValue = new byte[fieldLength];

            System.arraycopy(fieldData, srcPos, fieldValue, 0, fieldLength);

            nextPos =  srcPos + fieldLength;
        }
        else
        {

        }

        return nextPos;
    }

    /**
     *
     * @param fieldNo
     * @return
     */
    public Field getField(String fieldNo)
    {
        return fields.get(fieldNo);
    }

    /**
     *
     * @return
     */
    public Field getFieldByTag()
    {
        return fields.get(currentTag);
    }

    /**
     *
     * @return
     */
    public byte[] getFieldData()
    {
        return null;
    }

    public void encode()
    {

    }
}
