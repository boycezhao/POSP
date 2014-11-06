package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/29.
 */
public class FieldLengthException extends Exception{

    private Field field = null;

    public FieldLengthException(Field field)
    {
        this.field = field;
    }

    public String toString()
    {
        return "域" + field.getFieldNo() + ": 传入参数长度不等于固定字段长度，需要补0或补空格";
    }
}
