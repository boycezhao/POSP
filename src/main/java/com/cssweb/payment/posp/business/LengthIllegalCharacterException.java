package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/29.
 */
public class LengthIllegalCharacterException extends Exception{

    private Field field = null;

    public LengthIllegalCharacterException(Field field)
    {
        this.field = field;
    }

    public String toString()
    {

        return "域" + field.getFieldNo() + ": 长度中出现非法字符";
    }
}
