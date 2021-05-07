package com.stack.mapper;

import com.stack.rep.DataRep;
import org.junit.Assert;
import org.junit.Test;

public class StackMapperTest {

    @Test
    public void dataToDataRepInteger(){
        int data =  20;
        DataRep dataRep = StackMapper.dataToDataRep(data);
        Assert.assertEquals(20 , dataRep.getData());
    }
}
