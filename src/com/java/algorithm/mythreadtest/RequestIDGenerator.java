package com.java.algorithm.mythreadtest;

import java.nio.channels.SelectableChannel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class RequestIDGenerator implements CircularSeqGenerator  {

    private final static RequestIDGenerator INSTANCE = new RequestIDGenerator();
    private final static short SEQ_UPPER_LIMIT = 999;
    private short sequence =-1;

    private RequestIDGenerator()
    {

    }


    /**
     * 生成循环递增序列号
     * @return
     */
    @Override
    public synchronized  short nextSequence() {
        if(sequence>=SEQ_UPPER_LIMIT)
        {
            sequence=0;
        }else{
            sequence++;
        }
        return  sequence;
    }



    public String nextID (){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");

        //生成 序列号
        short sequenceNo = nextSequence();
        return "0049"+timestamp+df.format(sequenceNo);
    }

    public static RequestIDGenerator getInstance(){
        return INSTANCE;
    }

}
