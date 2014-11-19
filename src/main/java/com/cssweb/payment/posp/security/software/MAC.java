package com.cssweb.payment.posp.security.software;

import org.apache.commons.codec.binary.Hex;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by chenhf on 2014/11/10.
 */
public class MAC {




    /**
     * @param MAK
     * @param src
     * @return
     */
    public static byte[] calcMAC(byte[] MAK, byte[] src) {
        // 补足数据，8的倍数
        int length = src.length;

        int x = length % 8;
        int addLen = 0;
        if (x != 0) {
            addLen = 8 - length % 8;
        }

        byte[] data = new byte[length + addLen];
        System.arraycopy(src, 0, data, 0, length);


        // 获取第一块MAB
        int pos = 0;
        byte[] oper1 = new byte[8];
        System.arraycopy(data, pos, oper1, 0, 8);
        pos += 8;

        for (int i = 1; i < data.length / 8; i++) {

            // 获取后面MAB Block
            byte[] oper2 = new byte[8];
            System.arraycopy(data, pos, oper2, 0, 8);

            // 存放异或结果
            byte[] t = XOR.bytesXOR(oper1, oper2);
            oper1 = t;

            pos += 8;
        }

        // 将异或运算后的最后8个字节（RESULT BLOCK）转换成16个HEXDECIMAL：
        byte[] resultBlock = bytesToHexString(oper1).getBytes();
       // byte[] resultBlock = Hex.encodeHexString(oper1).getBytes();

        // 取前8个字节用mkey1，DES加密
        byte[] front8 = new byte[8];
        System.arraycopy(resultBlock, 0, front8, 0, 8);
        byte[] desfront8 = DES.encrypt(MAK, front8);

        // 取后面8个字节
        byte[] behind8 = new byte[8];
        System.arraycopy(resultBlock, 8, behind8, 0, 8);

        // 将加密后的结果与后8 个字节异或：
        byte[] resultXOR = XOR.bytesXOR(desfront8, behind8);

        // 用异或的结果TEMP BLOCK 再进行一次单倍长密钥算法运算
        //System.out.println("mak =  " + MAK.length);
        //System.out.println("xor = " + resultXOR.length);

        byte[] buff = DES.encrypt(MAK, resultXOR);

        // 将运算后的结果（ENC BLOCK2）转换成16 个HEXDECIMAL asc
        // 取8个长度字节
        byte[] retBuf = new byte[8];

        String finalResult = bytesToHexString(buff);
       // String finalResult = Hex.encodeHexString(buff);


        System.arraycopy(finalResult.getBytes(), 0, retBuf, 0, 8);

        return retBuf;
    }



    /**
     * @param data
     * @return
     */
    private static String bytesToHexString(byte[] data) {
        StringBuffer sb = new StringBuffer();

        String sTemp;
        for (int i = 0; i < data.length; i++) {
            sTemp = Integer.toHexString(0xFF & data[i]);

            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }





    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {

        String key = "abcdefgh";
        System.out.println("key测试工具用编码=" + Hex.encodeHexString(key.getBytes()));

        String data = "1234567887654321";
        System.out.println("data测试工具用编码=" + Hex.encodeHexString(data.getBytes()));



        byte[] mac = MAC.calcMAC(key.getBytes(), data.getBytes());
        System.out.println("mac长度=" + mac.length);

        System.out.println("mac=" + Hex.encodeHexString(mac).toUpperCase());
    }
}
