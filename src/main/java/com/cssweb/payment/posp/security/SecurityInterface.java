package com.cssweb.payment.posp.security;

/**
 * Created by chenhf on 2014/11/18.
 */
public interface SecurityInterface {

    public byte[] calcMAC(byte[] MAK, byte[] mab);
    public byte[] calcPIN(byte[] PIK, String pin, String pan);
}
