package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field90 extends Field {



    public Field90()
    {
        fieldName = "原始数据元";
        fieldNo = "90";

        fieldType = FIELD_TYPE_N;

        dataLen = 42;
    }


    @Override
    public int decode(byte[] fieldData, int srcPos)
    {

        int pos = srcPos;



        data = new byte[dataLen];
        System.arraycopy(fieldData, pos, data, 0, dataLen);

        fieldLength = dataLen;
        fieldValue = data;


        srcPos +=  fieldLength;


        Field90_1 field90_1 = new Field90_1();
        pos = field90_1.decode(data, field90_1.getBeginPos());
        addSubField(field90_1);

        Field90_2 field90_2 = new Field90_2();
        pos = field90_2.decode(data, field90_2.getBeginPos());
        addSubField(field90_2);

        Field90_3 field90_3 = new Field90_3();
        pos = field90_3.decode(data, field90_3.getBeginPos());
        addSubField(field90_3);

        Field90_4 field90_4 = new Field90_4();
        pos = field90_4.decode(data, field90_4.getBeginPos());
        addSubField(field90_4);

        Field90_5 field90_5 = new Field90_5();
        pos = field90_5.decode(data, field90_5.getBeginPos());
        addSubField(field90_5);


        return srcPos;
    }

    @Override
    public void encode() throws OverflowMaxLengthException {
        dataLen = 0;

        for (Field subField : fields.values())
        {
            // System.out.println("field121_5 no=" + subField.getFieldNo());
            dataLen += subField.getFieldLength();
        }



        data = new byte[dataLen];
        for (Field subField : fields.values())
        {
            System.arraycopy(subField.getFieldValue(), 0, data, subField.getBeginPos(), subField.getFieldLength());
        }

        fieldLength = dataLen;
        fieldValue = new byte[fieldLength];



        System.arraycopy(data, 0, fieldValue, 0, dataLen);
    }
}
