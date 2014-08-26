package com.cssweb.payment.posp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenhf on 2014/8/26.
 */
public class FieldData {

    private byte[] fieldData;
    private List<Field> fields;
    private int fieldDataLen;
    private HashMap<Integer, Field> fieldMap = new HashMap<Integer, Field>();


    public FieldData()
    {
        fieldDataLen = 0;
    }

    public byte[] getFieldData() {
        return fieldData;
    }
    public void decode(byte[] array, byte[] fieldData) {

        this.fieldData = fieldData;

        // 分析域值
        int fieldNo = 0;
        int srcPos = 0;
        int fieldLen = 0;

        for (int i=0; i<array.length; i++)
        {
            fieldNo = i + 1;

            if (array[fieldNo] == 0) {
                continue;
            }

            switch (fieldNo) {
                case 7: {
                    Field7 f7 = new Field7();
                    fieldLen = f7.getFieldLength();
                    byte[] data = new byte[fieldLen];
                    System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                    srcPos += fieldLen;
                    fieldMap.put(fieldNo, f7);
                    break;
                }
                case 11:{
                    Field11 f11 = new Field11();
                    fieldLen = f11.getFieldLength();
                    byte[] data = new byte[fieldLen];
                    System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                    srcPos += fieldLen;
                    fieldMap.put(fieldNo, f11);
                    break;
                }
                case 33:{
                    Field33 f33 = new Field33();

                    byte[] varLen = new byte[Field.FIELD_LENGTH_TYPE_VAR2];
                    System.arraycopy(fieldData, srcPos, varLen, 0, varLen.length);
                    srcPos += varLen.length;

                    fieldLen = Integer.parseInt(new String(varLen));
                    byte[] data = new byte[fieldLen];
                    System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                    srcPos += fieldLen;

                    fieldMap.put(fieldNo, f33);
                    break;
                }
                case 39: {
                    Field39 f39 = new Field39();
                    fieldLen = f39.getFieldLength();
                    byte[] data = new byte[fieldLen];
                    System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                    srcPos += fieldLen;
                    fieldMap.put(fieldNo, f39);
                    break;
                }
                case 70: {
                    Field70 f70 = new Field70();
                    fieldLen = f70.getFieldLength();
                    byte[] data = new byte[fieldLen];
                    System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
                    srcPos += fieldLen;
                    fieldMap.put(fieldNo, f70);
                    break;
                }
            }
        }
    }

    public int getFieldDataLen() {
        return fieldDataLen;
    }
    public void setFieldDataLen(int fieldDataLen) {
        this.fieldDataLen = fieldDataLen;
    }



    public List<Field> getFields() {
        return fields;
    }

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
}
