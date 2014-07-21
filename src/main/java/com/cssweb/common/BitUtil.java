package com.cssweb.common;

/**
 * Created by chenhf on 2014/7/21.
 */
public class BitUtil {

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

        System.out.println("result = " + result);
        return result;
    }

    public static byte[] byteToBitArray(byte b)
    {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }

    public static String byteToBitStr(byte b)
    {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }

    public static void main(String[] args)
    {
        BitUtil.binaryStrToByte("10000000");
        BitUtil.binaryStrToByte("01000000");

        String s = BitUtil.byteToBitStr((byte) 127);
        System.out.println("s = " + s);

        byte[] bs = BitUtil.byteToBitArray((byte)129);
        for (byte i:bs) {
            System.out.println("bs = " + i);
        }
    }
}
