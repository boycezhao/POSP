package com.cssweb.payment.posp;

import com.cssweb.payment.posp.network.CustomMessage;

/**
 * Created by chenhf on 2014/8/25.
 */
public interface BusinessMessage {

    public boolean decode(CustomMessage customMessage);
}
