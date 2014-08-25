package com.cssweb.payment.posp.network;

/**
 * Created by chenhf on 2014/7/21.
 */
public class BitUtil {

    /**
     * 把8位二进制字符串转换成字节
     * @param str
     * @return
     */
    public static byte binaryStrToByte(String str)
    {
        if (str.length()!= 8)
            return 0;

        byte result = 0b00000000;

        if (str.charAt(0) == '0')
        {
            result = Byte.parseByte(str, 2);
        }
        else
        {
            int tmp = Integer.parseInt(str, 2) - 256;
            result = (byte) tmp;
        }

       // System.out.println("result = " + result);
        return result;
    }

    /**
     * 把字节的每一位转换成二进制字节数组
     * @param b
     * @return
     */
    public static byte[] byteToBinaryArray(byte b)
    {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }

    /**
     * 把字节的每一位转换成二进制字符串
     * @param b
     * @return
     */
    public static String byteToBinaryStr(byte b)
    {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }

    public static void main(String[] args)
    {
        BitUtil.binaryStrToByte("01111111");
        BitUtil.binaryStrToByte("11000000");

        String s = BitUtil.byteToBinaryStr((byte) 127);
        System.out.println("s = " + s);

        byte[] bs = BitUtil.byteToBinaryArray((byte) 127);
        for (byte i:bs) {
            System.out.println("bs = " + i);
        }

        for (int i=0; i <128; i++) {

            System.out.println("i/8=" + i/8 + ",  i%8=" + i%8);

        }

    }
}
