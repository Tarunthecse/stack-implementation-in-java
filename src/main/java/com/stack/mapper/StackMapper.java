package com.stack.mapper;

import com.stack.rep.DataRep;

/**
 * StackMapper for converting data to data response model
 */
public class StackMapper {

    /**
     * @param data
     * @return Returning data rep model for response
     */
    public static DataRep dataToDataRep(int data){
        DataRep dataRep = new DataRep();
        dataRep.setData(data);
        return dataRep;
    }
}
