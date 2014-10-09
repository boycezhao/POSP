package com.cssweb.payment.posp.network;

public class ByteArrayIntUtil {

    /*
    主机序
    网络序
    小位
    大位
     */



    /**
     *
     * @param n
     * @return
     */
    public static  byte[] intToByteArrayH(int n) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (n >>> (24 - i * 8));
        }
        return b;
    }


    /**
     *
     * @param b
     * @return
     */
    public static  int byteArrayToIntH(byte[] b) {
        int mask = 0xff;
        int temp = 0;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res <<= 8;
            temp = b[i] & mask;
            res |= temp;
        }
        return res;
    }

    /**
     *
     * @param bytes
     * @return
     */
    public static int byteArrayToIntN(byte[] bytes) {
        int iOutcome = 0;
        byte bLoop;

        for (int i = 0; i < bytes.length; i++) {
            bLoop = bytes[i];
            iOutcome += (bLoop & 0xFF) << (8 * i);
        }
        return iOutcome;
    }

    public static byte[] intToByteArrayN(int iSource, int iArrayLen) {
        byte[] bLocalArr = new byte[iArrayLen];
        for (int i = 0; (i < 4) && (i < iArrayLen); i++) {
            bLocalArr[i] = (byte) (iSource >> 8 * i & 0xFF);
        }
        return bLocalArr;
    }








}
