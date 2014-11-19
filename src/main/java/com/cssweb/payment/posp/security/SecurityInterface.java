package com.cssweb.payment.posp.security;

/**
 * Created by chenhf on 2014/11/18.
 */
public interface SecurityInterface {

    public byte[] calcMAC(byte[] mab);
    public byte[] calcPIN(byte[] pin, byte[] pan);
}
