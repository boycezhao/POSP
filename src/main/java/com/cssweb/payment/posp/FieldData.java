package com.cssweb.payment.posp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by chenhf on 2014/8/26.
 */
public class FieldData {

    private byte[] fieldData;
    private List<Field> fields;
    private int fieldDataLen;

    public FieldData()
    {
        fieldDataLen = 0;
    }

    public byte[] getFieldData() {
        return fieldData;
    }

    public int getFieldDataLen() {
        return fieldDataLen;
    }

    public void setFieldDataLen(int fieldDataLen) {
        this.fieldDataLen = fieldDataLen;
    }

    public void setFieldData(byte[] fieldData) {
        this.fieldData = fieldData;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) throws IOException {
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
