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


        this.fieldData = fieldData;
        fieldDataLen = fieldData.length;

        // 分析域值
        int fieldNo = 0;
        int srcPos = 0;
        int nextPos = 0;
        int fieldLen = 0;

        for (int i = 0; i < array.length; i++) {
            fieldNo = i + 1;

            // 位无效，即没有设置相应的域内容
            if (array[i] == 0) {
                continue;
            }

            switch (fieldNo) {
                case 1: {
                    //只是代表位图2有效
                break;
                }
                case 2:
                {
                    Field2 field = new Field2();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 3:
                {
                    Field3 field = new Field3();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 4:
                {
                    Field4 field = new Field4();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 5:
                {
                    Field5 field = new Field5();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 6:
                {
                    Field6 field = new Field6();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }

                case 7: {
                    Field7 f7 = new Field7();
                    srcPos = f7.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, f7);
                    break;
                }
                case 9: {
                    Field9 field = new Field9();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 10: {
                    Field10 field = new Field10();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 11: {
                    Field11 f11 = new Field11();
                    srcPos = f11.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, f11);
                    break;
                }
                case 12: {
                    Field12 field = new Field12();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 13: {
                    Field13 field = new Field13();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 14: {
                    Field14 field = new Field14();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 15: {
                    Field15 field = new Field15();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 16: {
                    Field16 field = new Field16();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 18: {
                    Field18 field = new Field18();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 19: {
                    Field19 field = new Field19();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 22: {
                    Field22 field = new Field22();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 23: {
                    Field23 field = new Field23();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 25: {
                    Field25 field = new Field25();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 26: {
                    Field26 field = new Field26();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 28: {
                    Field28 field = new Field28();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 32: {
                    Field32 field = new Field32();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 33: {
                    Field33 f33 = new Field33();
                    srcPos = f33.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, f33);
                    break;
                }
                case 37: {
                    Field37 field = new Field37();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 38: {
                    Field38 field = new Field38();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 39: {
                    Field39 f39 = new Field39();
                    srcPos = f39.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, f39);
                    break;
                }
                case 41: {
                    Field41 field = new Field41();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 42: {
                    Field42 field = new Field42();
                    logger.info("42srcPos = " + srcPos);
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 43: {
                    Field43 field = new Field43();
                    logger.info("43srcPos = " + srcPos);
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 44: {
                    Field44 field = new Field44();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 48: {
                    Field48 field = new Field48();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 49: {
                    Field49 field = new Field49();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 50: {
                    Field50 field = new Field50();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 51: {
                    Field51 field = new Field51();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 52: {
                    Field52 field = new Field52();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 53: {
                    Field53 field = new Field53();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 54: {
                    Field54 field = new Field54();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 55: {
                    Field55 field = new Field55();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 57: {
                    Field57 field = new Field57();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 58: {
                    Field58 field = new Field58();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 59: {
                    Field59 field = new Field59();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 60: {
                    Field60 field = new Field60();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 61: {
                    Field61 field = new Field61();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 62: {
                    Field62 field = new Field62();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 63: {
                    Field63 field = new Field63();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 64: {
                    System.out.println("域64有效==================================================");
                    break;
                }
                case 70: {
                    Field70 f70 = new Field70();
                    srcPos = f70.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, f70);
                    break;
                }
                case 90: {
                    Field90 field = new Field90();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 96: {
                    Field96 field = new Field96();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 100: {
                    Field100 field = new Field100();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 102: {
                    Field102 field = new Field102();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 103: {
                    Field103 field = new Field103();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 121: {
                    Field121 field = new Field121();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 122: {
                    Field122 field = new Field122();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 123: {
                    Field123 field = new Field123();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                case 128: {
                    Field128 field = new Field128();
                    srcPos = field.decode(fieldData, srcPos);
                    fieldMap.put(fieldNo, field);
                    break;
                }
                default:
                    System.out.println("FieldData decode error.fieldNo=" + fieldNo);
            }//end switch
        }//end for

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
            if (fieldValue == null)
                logger.error("编码失败" + field.getFieldNo());
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
