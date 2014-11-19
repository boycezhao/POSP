package com.cssweb.payment.posp.security.software;

import org.apache.commons.codec.binary.Hex;

/**
 * Created by chenhf on 2014/11/18.
 */
public class XOR {

    /**
     * 单字节
     * @param src1
     * @param src2
     * @return
     */
    private static byte byteXOR(byte src1, byte src2) {
        return (byte) ((src1 & 0xFF) ^ (src2 & 0xFF));
    }

    /**
     * @param src1
     * @param src2
     * @return
     */
    public static byte[] bytesXOR(byte[] src1, byte[] src2) {
        int length = src1.length;

        if (length != src2.length) {
            return null;
        }

        byte[] result = new byte[length];

        for (int i = 0; i < length; i++) {
            result[i] = byteXOR(src1[i], src2[i]);
        }

        return result;
    }

    public static void main(String args[])
    {
        String src1 = "12345678";
        System.out.println("src1输入测试工具=" + Hex.encodeHexString(src1.getBytes()));

        String src2 = "87654321";
        System.out.println("src2输入测试工具=" + Hex.encodeHexString(src2.getBytes()));

        byte[] result = XOR.bytesXOR(src1.getBytes(), src2.getBytes());
        System.out.println("异或结果长度=" + result.length);

        System.out.println("xor = " + Hex.encodeHexString(result));
    }
}
