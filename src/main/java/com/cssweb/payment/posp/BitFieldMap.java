package com.cssweb.payment.posp;

import com.cssweb.payment.posp.network.BitUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhf on 2014/8/20.
 */
public class BitFieldMap {

    public static final int BIT_FIELD_MAP_SIZE = 8;

    private byte[] mainBitFieldMap = new byte[BIT_FIELD_MAP_SIZE];
    private byte[] extBitFieldMap = new byte[BIT_FIELD_MAP_SIZE];

    private List<Field> fields;
    private boolean isExtBitFieldMap;
    private int bitFieldMapLen;
    private char[] array = new char[128];


    public BitFieldMap()
    {
        isExtBitFieldMap = false;

        // 初始化
        for (int i=0; i<array.length; i++)
        {
            array[i] = '0';
        }
    }

    /**
     * 返回
     * @return
     */
    public char[] getArray()
    {
        return array;
    }


    public byte[] getExtBitFieldMap() {
        return extBitFieldMap;
    }

    public int getExtBitFieldMapLen()
    {
        return extBitFieldMap.length;
    }

    public void setExtBitFieldMap(byte[] extBitFieldMap) {
        this.extBitFieldMap = extBitFieldMap;
    }

    public byte[] getMainBitFieldMap() {
        return mainBitFieldMap;
    }

    public int getMainBitFieldMapLen()
    {
        return mainBitFieldMap.length;
    }

    public void setMainBitFieldMap(byte[] mainBitFieldMap) {
        this.mainBitFieldMap = mainBitFieldMap;
    }

    /**
     * 返回主位图
     * @return
     */
    public void setMainBitFieldMap()
    {
        String binaryStr = "";
        for (int i=0, j=1; i<64; i++, j++)
        {
            binaryStr += array[i];

            // 每8个字节执行一次
            if (j == 8)
            {
                System.out.println("i=" +i + ",j=" + j + ", binaryStr=" + binaryStr);

                byte b = BitUtil.binaryStrToByte(binaryStr);

                int index = i/8;
                mainBitFieldMap[index] = b;


                binaryStr = "";
                j = 0;
            }
        }//end for
    }

    /**
     * 返回扩展位图
     * @return
     */
    public void setExtBitFieldMap()
    {
        String binaryStr = "";
        for (int i=64, j=1; i<128; i++, j++)
        {
            binaryStr += array[i];

            // 每8个字节执行一次
            if (j == 8)
            {
                System.out.println("i=" +i + ",j=" + j + ", binaryStr=" + binaryStr);

                byte b = BitUtil.binaryStrToByte(binaryStr);

                int index = i/8;
                extBitFieldMap[index-8] = b;

                binaryStr = "";
                j = 0;
            }
        }//end for
    }


    private void setFieldValid()
    {
        for (Field field : fields)
        {
            int fieldNo = field.getFieldNo();

            array[fieldNo - 1] = '1'; // 置有效位

            if (fieldNo > 64) {
                array[0] = '1'; // 说明位图2有效
                isExtBitFieldMap = true;
            }
        }
    }


    public void setFields(List<Field> fields)
    {
        this.fields = fields;

        setFieldValid();



        setMainBitFieldMap();
        bitFieldMapLen = mainBitFieldMap.length;

        if (isExtBitFieldMap) {
            setExtBitFieldMap();
            bitFieldMapLen += extBitFieldMap.length;
        }
    }

    /**
     * 是否有扩展位图
     * @return
     */
    public boolean isExtBitFieldMap()
    {
        return isExtBitFieldMap;
    }

    public int getBitFieldMapLen()
    {
        return bitFieldMapLen;
    }

}
