package com.cssweb.payment.posp.security.software;

import org.apache.commons.codec.binary.Hex;

/**
 * Created by chenhf on 2014/11/10.
 */
public class PIN {


    /**
     *
     * @param PIN
     * @return
     */
    public static byte[] getPINBlock(String PIN)
    {
        byte[] pin = PIN.getBytes();
        byte len = (byte) pin.length;

        byte[] bcd = BCD.A2B(pin);

        byte[] pinBlock = new byte[8];

        // 初始化或补数据
        for (int i=0; i<pinBlock.length; i++)
        {
            pinBlock[i] = (byte)0xFF;
        }

        //长度
        pinBlock[0] = len;

        //PIN
        System.arraycopy(bcd, 0, pinBlock, 1, bcd.length);

        return pinBlock;
    }

    /**
     *
     * @param PAN
     * @return
     */
    public static byte[] getPANBlock(String PAN)
    {
        int len = PAN.length();
        int begin = len - 12 - 1;
        String pan = PAN.substring(begin, begin + 12);
       // System.out.println("pan=" + pan);

        byte[] bcd = BCD.A2B(pan.getBytes());

        byte[] panBlock = new byte[8];
        for (int i=0; i<panBlock.length; i++)
        {
            panBlock[i] = 0x00;
        }

        System.arraycopy(bcd, 0, panBlock, 8-bcd.length, bcd.length);

        return panBlock;
    }

    /**
     * 采用双倍长密钥算法计算
     * @param PIK
     * @param pin
     * @param pan
     * @return
     */
    public static byte[] encryptPIN(byte[] PIK, String pin, String pan)
    {
        byte[] pinBlock = getPINBlock(pin);

        for (int i=0; i<pinBlock.length; i++) {
            System.out.print("pinBlock[" + i + "]=" + byte2Hex(pinBlock[i]) + ",");
        }


        System.out.println();


        byte[] panBlock = PIN.getPANBlock(pan);
        for (int i=0; i<panBlock.length; i++) {
            System.out.print("panBlock[" + i + "]=" + byte2Hex(panBlock[i]) + ",");
        }

        System.out.println();

        byte[] xor = XOR.bytesXOR(panBlock, pinBlock);
        for (int i=0; i<xor.length; i++) {
            System.out.print("xor[" + i + "]=" + byte2Hex(xor[i]) + ",");
        }
        System.out.println();
        System.out.println("异或结果输入测试工具=" + Hex.encodeHexString(xor));


        byte[] encryptPIN = DESede.encrypt(PIK, xor);
        return encryptPIN;
    }

    /**
     *
     * @param b
     * @return
     */
    public static String byte2Hex(byte b)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("0x");

        String hex = Integer.toHexString((b & 0x000000FF) | 0xFFFFFF00).substring(6).toUpperCase();
        sb.append(hex);

        return sb.toString();
    }

    public static void main(String args[])
    {
        String PIK = "1234567812345678"; //采用双倍密钥算法，所以密钥长度必须是16字节
        System.out.println("测试工具用编码key=" + Hex.encodeHexString(PIK.getBytes()));

        String pin = "123456";
        String pan = "123456789012345678";

        byte[] result = PIN.encryptPIN(PIK.getBytes(), pin, pan);
        System.out.println("加密pin=" + Hex.encodeHexString(result).toUpperCase());
    }
}
