package com.cssweb.payment.posp.business;

import com.cssweb.payment.posp.network.CustomMessage;

/**
 * Created by chenhf on 2014/8/25.
 */
public interface BusinessAction {

    public CustomMessage process(CustomMessage customMessage);
}
