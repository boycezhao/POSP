package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/27.
 */
public class OverflowMaxLengthException extends Exception{

    private Field field = null;

    public OverflowMaxLengthException(Field field)
    {
        this.field = field;
    }

    public String toString()
    {

        return "域" + field.getFieldNo() + ": 超出最大长度";
    }

}
