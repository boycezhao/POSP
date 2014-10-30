package com.cssweb.payment.posp.network;


import com.cssweb.payment.posp.business.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenhf on 2014/8/26.
 */
public class FieldData {
    private static final Logger logger = LogManager.getLogger(FieldData.class.getName());

    private byte[] fieldData;
    private int fieldDataLen;

    private List<Field> fields;

    // 存放解码后的域内容
    private HashMap<Integer, Field> fieldMap = new HashMap<Integer, Field>();


    public FieldData()
    {
        fieldDataLen = 0;
    }


    public void decode(byte[] array, byte[] fieldData) {

        try {


            this.fieldData = fieldData;
            fieldDataLen = fieldData.length;

            // 分析域值
            int fieldNo = 0;
            int srcPos = 0;
            int fieldLen = 0;

            for (int i = 0; i < array.length; i++) {
                fieldNo = i + 1;

                // 位无效，即没有设置相应的域内容
                if (array[i] == 0) {
                    continue;
                }

                switch (fieldNo) {
                    case 1:
                    case 64: {
                        break;
                    }
                    case 7: {
                        Field7 f7 = new Field7();
                        fieldLen = f7.getFieldLength();
                        byte[] data = new byte[fieldLen];
                        System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                        f7.setFieldValue(data);
                        srcPos += fieldLen;
                        fieldMap.put(fieldNo, f7);
                        break;
                    }
                    case 11: {
                        Field11 f11 = new Field11();
                        fieldLen = f11.getFieldLength();
                        byte[] data = new byte[fieldLen];
                        System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                        f11.setFieldValue(data);
                        srcPos += fieldLen;
                        fieldMap.put(fieldNo, f11);
                        break;
                    }
                    case 33: {
                        Field33 f33 = new Field33();

                        byte[] varLen = new byte[Field.FIELD_LENGTH_TYPE_VAR2];
                        System.arraycopy(fieldData, srcPos, varLen, 0, varLen.length);
                        srcPos += varLen.length;

                        fieldLen = Integer.parseInt(new String(varLen));
                        byte[] data = new byte[fieldLen];
                        System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                        f33.setFieldValue(data);
                        srcPos += fieldLen;

                        fieldMap.put(fieldNo, f33);
                        break;
                    }
                    case 39: {
                        Field39 f39 = new Field39();
                        fieldLen = f39.getFieldLength();
                        byte[] data = new byte[fieldLen];
                        System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                        f39.setFieldValue(data);
                        srcPos += fieldLen;
                        fieldMap.put(fieldNo, f39);
                        break;
                    }
                    case 70: {
                        Field70 f70 = new Field70();
                        fieldLen = f70.getFieldLength();
                        byte[] data = new byte[fieldLen];
                        System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                        f70.setFieldValue(data);
                        srcPos += fieldLen;
                        fieldMap.put(fieldNo, f70);
                        break;
                    }
                    default:
                        System.out.println("FieldData decode error.fieldNo=" + fieldNo);
                }//end switch
            }//end for

        }catch (FieldLengthException e) {
            e.printStackTrace();
        } catch (OverflowMaxLengthException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param fields
     * @throws java.io.IOException
     */
    public void encode(List<Field> fields) throws IOException {
        this.fields = fields;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // ByteBuffer

        //StringBuffer sb = new StringBuffer();
        for (Field field : fields)
        {

            byte[] fieldValue = field.getFieldValue();

            baos.write(fieldValue);
        }


        fieldData =  baos.toByteArray();

        fieldDataLen = fieldData.length;
    }

    public byte[] getFieldData() {
        return fieldData;
    }

    public Field getField(int fieldNo)
    {
        return fieldMap.get(fieldNo);
    }
    public List<Field> getFields() {
        return fields;
    }

    public int getFieldDataLen() {
        return fieldDataLen;
    }
    public void setFieldDataLen(int fieldDataLen) {
        this.fieldDataLen = fieldDataLen;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("域数据总长度=" + fieldDataLen);
        sb.append("; 域数据=" + new String(fieldData));
        return sb.toString();
    }
}
