package com.cssweb.payment.posp.business;

/**
 * Created by chenhf on 2014/10/20.
 */
public class Field121_5 extends Field {

    private Field121_5_FD FD;
    private Field121_5_ID ID;

    public Field121_5_FD getFD() {
        return FD;
    }

    public void setFD(Field121_5_FD FD) {
        this.FD = FD;
    }

    public Field121_5_ID getID() {
        return ID;
    }

    public void setID(Field121_5_ID ID) {
        this.ID = ID;
    }

    public Field121_5()
    {
        fieldName = "转入和转出方标识代码/手续费信息";
        fieldNo = "121.5";

        fieldType = FIELD_TYPE_ANS;


        dataLen = 38;



        beginPos = 43;



    }
}
