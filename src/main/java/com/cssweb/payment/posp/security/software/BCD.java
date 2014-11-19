package com.cssweb.payment.posp.security.software;

/**
 * Created by chenhf on 2014/11/11.
 * 参考http://blog.csdn.net/centralperk/article/details/7533857
 * 此类可以用apache common codec hex代替
 */
public class BCD {

    /**
     *
     * @param asc
     * @return
     */
    private static byte asc2bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);

        return bcd;
    }

    /**
     *
     * @param ascii
     * @return
     */
    public static byte[] A2B(byte[] ascii)
    {
        int asc_len = ascii.length;

        byte[] bcd = new byte[asc_len / 2];

        int j = 0;

        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc2bcd(ascii[j++]);

            bcd[i] = (byte) ( ( (j >= asc_len) ? 0x00 : asc2bcd(ascii[j++]) ) + (bcd[i] << 4) );
        }

        return bcd;
    }

    /**
     *
     * @param bcd
     * @return
     */
    public static String B2A(byte[] bcd)
    {
        char temp[] = new char[bcd.length * 2], val;

        for (int i = 0; i < bcd.length; i++) {
            val = (char) (((bcd[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bcd[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    public static void main(String[] args)
    {
        byte[] bcd = BCD.A2B("1234567812345678".getBytes());
        for (int i=0; i<bcd.length; i++)
        {
            System.out.print("bcd[" + i + "]=" + bcd[i] + ";");
        }
        System.out.println();

        String ascii = BCD.B2A(bcd);
        System.out.println("ascii = " + ascii);
    }
}
