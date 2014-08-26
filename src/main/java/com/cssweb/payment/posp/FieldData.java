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
        for (int i=0; i<array.length; i++)
        {
            fieldNo = i + 1;

            if (array[i] == '1')
            {
                Field field = new Field();
                field.setFieldNo(fieldNo);

                fields.put(fieldNo, field);


            }
        }




        char[] array = bitFieldMap.getArray();
        byte[] fieldData = customMessage.getFieldData();
        int srcPos = 0;
        byte[] data = null;
        int fieldLen = 0;
        for (int i=0; i<array.length; i++)
        {
            if (array[i] != '1') {
                continue;
            }

            switch (i)
            {
                case 7:
                    field7 = new Field7();
                    fieldLen = field7.getFieldLength();
                    data = new byte[fieldLen];
                    break;

                case 11:
                    field11 = new Field11();
                    fieldLen = field11.getFieldLength();
                    data = new byte[fieldLen];
                    break;
            }

            System.arraycopy(fieldData, srcPos, data, 0, fieldLen);
            srcPos += fieldLen;
        }




        byte[] f7data = new byte[field7.getFieldLength()];

        field7.setFieldValue(f7data);
        srcPos += f7data.length;

        byte[] f11data = new byte[field11.getFieldLength()];
        System.arraycopy(fieldData, srcPos, f11data, 0, f11data.length);
        field11.setFieldValue(f11data);
        srcPos += f11data.length;

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
