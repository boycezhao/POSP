package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/29.
 */
public class IllegalCharacterException extends Exception{

    private Field field = null;

    public IllegalCharacterException(Field field)
    {
        this.field = field;
    }

    public String toString()
    {

        return "域" + field.getFieldNo() + ": 非法字符";
    }
}
