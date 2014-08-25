package com.cssweb.payment.posp;

import com.cssweb.payment.posp.network.CustomMessage;

/**
 * Created by chenhf on 2014/8/25.
 */
public class TestNetworkRequest implements BusinessMessage{
    private Field7 field7 = new Field7();
    private Field11 field11 = new Field11();
    private Field33 field33 = new Field33();
    private Field39 field39 = new Field39();
    private Field70 field70 = new Field70();

    @Override
    public boolean decode(CustomMessage customMessage)
    {

        BitFieldMap bitFieldMap = customMessage.getBitFieldMap();

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


        return true;
    }

    public String toString()
    {
        return "";
    }

}
