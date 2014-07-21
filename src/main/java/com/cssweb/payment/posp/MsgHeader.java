package com.cssweb.payment.posp;

/**
 * Created by chenhf on 2014/7/21.
 */
public class MsgHeader {

    // 总共46字节

    private byte headerLength = 46;
    private byte version;
    private int length;
    private byte[] destId = new byte[11]; // array<byte>
    private byte[] sourceId = new byte[11];
    private byte[] reserved = new byte[3];
    private byte batchNo;
    private byte[] tradeInfo = new byte[8];
    private byte userInfo;
    private byte[] rejectCode = new byte[5];


}
