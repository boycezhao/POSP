package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/15.
 */
public class Field121 extends Field {

    public Field121()
    {
        fieldName = "预付卡发卡机构保留";
        fieldNo = "121";

        fieldType = FIELD_TYPE_ANS;

        fieldValueType = FIELD_VALUE_TYPE_LLLV;
        maxFieldLength = 100;


    }

    @Override
    public int decode(byte[] fieldData, int srcPos)
    {
        int beginPos = 0;

        Field121_1 field121_1 = new Field121_1();
        beginPos = srcPos + field121_1.getBeginPos();
        System.arraycopy(fieldData, beginPos, field121_1.getFieldValue(), 0, field121_1.getFieldLength());
        this.fields.put(field121_1.getFieldNo(), field121_1);

        Field121_2 field121_2 = new Field121_2();
        beginPos = srcPos + field121_2.getBeginPos();
        System.arraycopy(fieldData, beginPos, field121_2.getFieldValue(), 0, field121_2.getFieldLength());
        this.fields.put(field121_2.getFieldNo(), field121_2);

        Field121_3 field121_3 = new Field121_3();
        beginPos = srcPos + field121_3.getBeginPos();
        System.arraycopy(fieldData, beginPos, field121_3.getFieldValue(), 0, field121_3.getFieldLength());
        this.fields.put(field121_3.getFieldNo(), field121_3);

        Field121_4 field121_4 = new Field121_4();
        beginPos = srcPos + field121_4.getBeginPos();
        System.arraycopy(fieldData, beginPos, field121_4.getFieldValue(), 0, field121_4.getFieldLength());
        this.fields.put(field121_4.getFieldNo(), field121_4);

        // 读标志
        byte[] tag = new byte[2];
        System.arraycopy(fieldData, beginPos, tag, 0, 2);
        String tagStr = new String(tag);

        Field121_5 field121_5 = new Field121_5();
        if (tagStr.equalsIgnoreCase("FD"))
        {
            Field121_5_FD field121_5_fd = new Field121_5_FD();
            srcPos = field121_5_fd.decode(fieldData, srcPos);

            field121_5.setCurrentTag(tagStr);
            field121_5.setFD(field121_5_fd);
        }
        if (tagStr.equalsIgnoreCase("ID"))
        {
            field121_5.setCurrentTag(tagStr);

            Field121_5_ID field121_5_id = new Field121_5_ID();
        }


        return srcPos;
    }
}
