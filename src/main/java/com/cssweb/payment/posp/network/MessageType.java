package com.cssweb.payment.posp.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by chenhf on 2014/7/21.
 */
public class    MessageType {
    private static final Logger logger = LogManager.getLogger(MessageType.class.getName());

    public static final int MSG_TYPE_SIZE = 4;

    private byte[] msgType;

    /*
    public String getMsgType() {
        return msgType;
    }
    */

    public byte[] getMsgType()
    {
        return msgType;
    }

    public int getMsgTypeLen()
    {
        if (msgType == null)
            return 0;

        return msgType.length;
    }

    public void setMsgType(String msgType) {
        // 必须是4字节长度

        this.msgType = msgType.getBytes();
    }

    public void setMsgType(byte[] msgType)
    {
        this.msgType = msgType;
    }
}
