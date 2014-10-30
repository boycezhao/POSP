package com.cssweb.payment.posp.network;

/**
 * Created by chenhf on 2014/8/22.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by chenhf on 2014/7/21.
 */
public class MsgHeader {
    private static final Logger logger = LogManager.getLogger(MsgHeader.class.getName());

    // 总共46字节
    public static final int MSG_HEADER_SIZE = 46;

    private byte msgHeaderLen;
    private byte version;
    private byte[] totalLen = new byte[4];
    private byte[] destId = new byte[11];
    private byte[] srcId = new byte[11];
    private byte[] reserved = new byte[3];
    private byte batchNo;
    private byte[] tradeInfo = new byte[8];
    private byte userInfo;
    private byte[] rejectCode = new byte[5];

    private byte[] msgHeader;
    private int msgContentSize;



    /**
     * 解码消息头
     * @param msgHeader
     * @return
     * @throws java.io.IOException
     */
    public boolean decode(byte[] msgHeader)  {
        try {
        ByteArrayInputStream bais = new ByteArrayInputStream(msgHeader);
        DataInputStream in = new DataInputStream(bais);



            msgHeaderLen = in.readByte();
            version = in.readByte();
            in.readFully(totalLen);
            in.readFully(destId);
            in.readFully(srcId);
            in.readFully(reserved);
            batchNo = in.readByte();
            in.readFully(tradeInfo);
            userInfo = in.readByte();
            in.readFully(rejectCode);

            in.close();
            bais.close();


            // 计算消息内容大小
            String sTotalLen = new String(totalLen);
            Integer len = Integer.parseInt(sTotalLen);
            len = len - MSG_HEADER_SIZE;
            msgContentSize = len.intValue();
            logger.info("msgContentSize = " + msgContentSize);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 编码消息头
     * @param totalLen
     * @param destId
     * @param srcId
     * @param batchNo
     * @param tradeInfo
     * @param userInfo
     * @param rejectCode
     * @return
     * @throws java.io.IOException
     */
    public boolean encode(int totalLen, String destId, String srcId, byte batchNo, String tradeInfo, byte userInfo, String rejectCode) throws IOException {
        setMsgHeaderLen((byte)46);
        setVersion((byte)0b00000010);
        setTotalLen(totalLen);
        setDestId(destId);
        setSourceId(srcId);

        byte[] reserved = new byte[3];
        for (int i=0; i<reserved.length; i++)
            reserved[i] = 0;
        setReserved(reserved);

        setBatchNo(batchNo);
        setTradeInfo(tradeInfo); // 8字节定长
        setUserInfo(userInfo);
        setRejectCode(rejectCode); // 5字节定长

        toByteArray();

        return true;
    }


    private void toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write(msgHeaderLen);
        baos.write(version);
        baos.write(totalLen);
        baos.write(destId);
        baos.write(srcId);
        baos.write(reserved);
        baos.write(batchNo);
        baos.write(tradeInfo);
        baos.write(userInfo);
        baos.write(rejectCode);

        msgHeader =  baos.toByteArray();
    }


    public byte[] getMsgHeader() {
        return msgHeader;
    }
    public void setMsgHeader(byte[] msgHeader) {
        this.msgHeader = msgHeader;
    }

    public int getMsgContentSize() {
        return msgContentSize;
    }
    public void setMsgContentSize(int msgContentSize) {
        this.msgContentSize = msgContentSize;
    }


    public byte getMsgHeaderLen() {

        return msgHeaderLen;
    }
    public void setMsgHeaderLen(byte msgHeaderLen)
    {
        this.msgHeaderLen = msgHeaderLen;
    }

    public void setVersion(byte version)
    {
        this.version = version;
    }

    public void setTotalLen(int totalLen)
    {
        String s = String.valueOf(totalLen);


        String str ="0000";

        // 不足4位，前面补0
        String val  = str.substring(0, str.length() - s.length()) + s;

        this.totalLen = val.getBytes();
    }

    public void setDestId(String destId)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(destId);

        for (int i = destId.length(); i<11; i++)
        {
            sb.append(" "); // 不足11位，后补空格
        }

        this.destId = sb.toString().getBytes();
    }

    public void setSourceId(String srcId)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(srcId);

        for (int i = srcId.length(); i<11; i++)
        {
            sb.append(" "); // 不足11位，后补空格
        }


        this.srcId = sb.toString().getBytes();
    }

    public void setReserved(byte[] reserved)
    {
        this.reserved = reserved;
    }

    public void setBatchNo(byte batchNo)
    {
        this.batchNo = batchNo;
    }

    public void setTradeInfo(String tradeInfo)
    {
        this.tradeInfo = tradeInfo.getBytes();
    }

    public void setUserInfo(byte userInfo)
    {
        this.userInfo = userInfo;
    }

    public void setRejectCode(String rejectCode)
    {
        this.rejectCode = rejectCode.getBytes();
    }

}