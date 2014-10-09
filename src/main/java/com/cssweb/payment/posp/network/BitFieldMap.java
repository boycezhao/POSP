package com.cssweb.payment.posp.network;

import com.cssweb.payment.posp.business.Field;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by chenhf on 2014/8/20.
 */
public class BitFieldMap {
    private static final Logger logger = LogManager.getLogger(BitFieldMap.class.getName());

    public static final int BIT_FIELD_MAP_SIZE = 8;

    private byte[] array = new byte[128];
    private byte[] mainBitFieldMap = new byte[BIT_FIELD_MAP_SIZE];
    private byte[] extBitFieldMap = new byte[BIT_FIELD_MAP_SIZE];

    private List<Field> fields;

    private boolean isExtBitFieldMap;

    private int bitFieldMapLen;



    public BitFieldMap()
    {
        isExtBitFieldMap = false;

        // 初始化
        for (int i=0; i<array.length; i++)
        {
            array[i] = 0;
        }
    }

    /**
     * 返回
     * @return
     */
    public byte[] getArray()
    {
        return array;
    }
    public String getArrayStr()
    {
        String s = "";

        for (int i=0; i<array.length; i++)
        {
            s += array[i];
        }

        return s;
    }

    public byte[] getMainBitFieldMap() {
        return mainBitFieldMap;
    }
    public int getMainBitFieldMapLen()
    {
        return mainBitFieldMap.length;
    }

    /**
     * 把字节转换成二进制字符串，同时设置array数组
     * @param mainBitFieldMap
     */
    public void setMainBitFieldMap(byte[] mainBitFieldMap) {
        this.mainBitFieldMap = mainBitFieldMap;

        // 把主位图第一个字节转成二进制数组
        byte first = mainBitFieldMap[0];
        byte[] firstByteArray = BitUtil.byteToBinaryArray(first);

        if (firstByteArray[0] == 1)
        {
            isExtBitFieldMap = true;
        }
        else
        {
            isExtBitFieldMap = false;
        }

        int pos = 0;
        for (int i=0; i<mainBitFieldMap.length; i++)
        {
            byte[] ba = BitUtil.byteToBinaryArray(mainBitFieldMap[i]);

            for (int j=0; j<ba.length; j++)
            {
                byte b = ba[j];

                array[pos++] = b;
            }
        }

        bitFieldMapLen = mainBitFieldMap.length;
    }

    /**
     * 把8个长度的二进制字符串转换成字节
     * @return
     */
    private void setMainBitFieldMap()
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



    public byte[] getExtBitFieldMap() {
        return extBitFieldMap;
    }
    public int getExtBitFieldMapLen()
    {
        return extBitFieldMap.length;
    }
    public void setExtBitFieldMap(byte[] extBitFieldMap) {
        this.extBitFieldMap = extBitFieldMap;

        int pos = 64;
        for (int i=0; i<extBitFieldMap.length; i++)
        {
            byte[] ba = BitUtil.byteToBinaryArray(extBitFieldMap[i]);

            for (int j=0; j<ba.length; j++)
            {
                byte b = ba[j];

                array[pos++] = b;
            }
        }

        bitFieldMapLen += extBitFieldMap.length;
    }

    /**
     * 返回扩展位图
     * @return
     */
    private void setExtBitFieldMap()
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

            array[fieldNo - 1] = 1; // 置有效位

            if (fieldNo > 64) {
                array[0] = 1; // 说明位图2有效
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
