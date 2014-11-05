package com.cssweb.payment.posp.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
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
    protected Map<String, Field> fields = new LinkedHashMap<String, Field>();





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
        this.fieldLength = fieldLength;
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


    public void setFieldValue(byte[] fieldValue) {
        this.fieldValue = fieldValue;
    }
    public byte[] getFieldValue()
    {
        return fieldValue;
    }


    public byte[] getData() {
        return data;
    }
    public void setData(String data) throws OverflowMaxLengthException, FieldLengthException {
        setData(data.getBytes());
    }
    public void setData(byte[] data) throws OverflowMaxLengthException, FieldLengthException {
        this.data = data;

        encode();
    }

    public int getDataLen() {
        return dataLen;
    }
    public void setDataLen(int dataLen) {
        this.dataLen = dataLen;
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

        String s = fieldNo + "(" + fieldName + ")：" + new String(data) + "; 实际长度：" + fieldLength + "; 数据长度：" + dataLen;

        return s;
    }

    /**
     *
     * @param field

    public void addField(Field field)
    {
        System.arraycopy(field.getFieldValue(), 0, fieldValue, field.getBeginPos(), field.getFieldLength());

        fields.put(field.getFieldName(), field);
    }*/

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
     * @param subField
     */
    public void addSubField(Field subField)
    {
        fields.put(subField.getFieldNo(), subField);
    }
    /**
     *
     * @param fieldNo
     * @return
     */
    public Field getSubField(String fieldNo)
    {
        return fields.get(fieldNo);
    }


    /**
     *
     * @param field
     */
    public void addSubFieldByTag(Field field)
    {
        currentTag = field.getTag();

        fields.put(currentTag, field);

        // copy子域的值

        data = field.getData();
        dataLen = field.getDataLen();

        fieldValue = field.getFieldValue();
        fieldLength = field.getFieldLength();
    }
    /**
     *
     * @return
     */
    public Field getSubFieldByTag()
    {
        return fields.get(currentTag);
    }


    /**
     *
     * @throws OverflowMaxLengthException
     * @throws FieldLengthException
     */
    public void encode() throws OverflowMaxLengthException, FieldLengthException {
        if (fieldValueType == FIELD_VALUE_TYPE_DEFAULT)
        {
            if (data.length > dataLen)
                throw new OverflowMaxLengthException(this);

            if (data.length < dataLen)
                throw new FieldLengthException(this);

            fieldValue = data;
            fieldLength = dataLen;
        }
        else if (fieldValueType == FIELD_VALUE_TYPE_LLV)
        {
            //前面2字节表示长度
            dataLen = data.length;
            if ( (dataLen) > maxFieldLength )
                throw new OverflowMaxLengthException(this);

            fieldLength = 2 + dataLen;
            fieldValue = new byte[fieldLength];

            String str ="00";
            String dataLenStr = String.valueOf(dataLen);
            String val  = str.substring(0, str.length() - dataLenStr.length()) + dataLenStr;

            System.arraycopy(val.getBytes(), 0, fieldValue, 0, 2);
            System.arraycopy(data, 0, fieldValue, 2, dataLen);
        }
        else if (fieldValueType == FIELD_VALUE_TYPE_LLLV)
        {
            //前面3字节表示长度
            dataLen = data.length;
            if ( (dataLen) > maxFieldLength )
                throw new OverflowMaxLengthException(this);

            fieldLength = 3 + dataLen;
            fieldValue = new byte[fieldLength];

            String str ="000";
            String dataLenStr = String.valueOf(dataLen);
            String val  = str.substring(0, str.length() - dataLenStr.length()) + dataLenStr;

            System.arraycopy(val.getBytes(), 0, fieldValue, 0, 3);
            System.arraycopy(data, 0, fieldValue, 3, dataLen);
        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TV)
        {
            fieldLength = 2 + dataLen;
            fieldValue = new byte[fieldLength];

            System.arraycopy(tag.getBytes(), 0, this.fieldValue, 0, 2);
            System.arraycopy(data, 0, this.fieldValue, 2, dataLen);
        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TLLV)
        {

        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TLLLV)
        {

        }
    }


    /**
     *
     * @param fieldData
     * @param srcPos
     */
    public int decode(byte[] fieldData, int srcPos)
    {
        int nextPos = 0;

        if (fieldValueType == FIELD_VALUE_TYPE_DEFAULT) {
            data = new byte[dataLen];

            System.arraycopy(fieldData, srcPos, data, 0, dataLen);
            fieldLength = dataLen;

            fieldValue = data;

            nextPos =  srcPos + fieldLength;
        }
        else if (fieldValueType == FIELD_VALUE_TYPE_LLV)
        {
            byte[] varLen = new byte[2];
            System.arraycopy(fieldData, srcPos, varLen, 0, 2);
            dataLen = Integer.parseInt(new String(varLen));



            data = new byte[dataLen];

            System.arraycopy(fieldData, srcPos+2, data, 0, dataLen);

            fieldLength = 2 + dataLen;
            fieldValue = new byte[fieldLength];
            System.arraycopy(varLen, 0, fieldValue, 0, 2);
            System.arraycopy(data, 0, fieldValue, 2, dataLen);

            nextPos =  srcPos + fieldLength;
        }
        else if(fieldValueType == FIELD_VALUE_TYPE_LLLV)
        {
            byte[] varLen = new byte[3];
            System.arraycopy(fieldData, srcPos, varLen, 0, 3);
            dataLen = Integer.parseInt(new String(varLen));



            data = new byte[dataLen];

            System.arraycopy(fieldData, srcPos+3, data, 0, dataLen);

            fieldLength = 3 + dataLen;
            fieldValue = new byte[fieldLength];
            System.arraycopy(varLen, 0, fieldValue, 0, 3);
            System.arraycopy(data, 0, fieldValue, 3, dataLen);

            nextPos =  srcPos + fieldLength;
        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TV)
        {
            byte[] varLen = new byte[2];
            System.arraycopy(fieldData, srcPos, varLen, 0, 2);

            tag = new String(varLen);



            data = new byte[dataLen];

            System.arraycopy(fieldData, srcPos+2, data, 0, dataLen);

            fieldLength = 2 + dataLen;
            fieldValue = new byte[fieldLength];
            System.arraycopy(varLen, 0, fieldValue, 0, 2);
            System.arraycopy(data, 0, fieldValue, 2, dataLen);

            nextPos =  srcPos + fieldLength;
        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TLLV)
        {

        }
        else if(fieldValueType == FIELD_VALUE_TYPE_TLLLV)
        {

        }
        else
        {

        }

        return nextPos;
    }
}
