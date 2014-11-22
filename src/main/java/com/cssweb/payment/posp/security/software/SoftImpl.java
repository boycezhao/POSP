package com.cssweb.payment.posp.security.software;

import com.cssweb.payment.posp.security.SecurityInterface;

/**
 * Created by chenhf on 2014/11/19.
 */
public class SoftImpl implements SecurityInterface{


    @Override
    public byte[] calcMAC(byte[] MAK, byte[] mab) {
        return MAC.calcMAC(MAK, mab);
    }

    @Override
    public byte[] calcPIN(byte[] PIK, String pin, String pan) {

        return PIN.calcPIN(PIK, pin, pan);
    }
}
