package com.exception.application.service;

import com.exception.application.dto.RequestBase;
import org.springframework.stereotype.Service;

@Service
public class BaseService{

    public String handleYourSelf(RequestBase st) throws  IllegalArgumentException{
        try{
            System.out.println(st);
          /*      if (!st.getName().isEmpty()){
                  throw    st.getName().equals("1") ? new ArrayIndexOutOfBoundsException("You rock start") :
                          new IllegalArgumentException("base Controller fa");
                }*/
           }catch(Exception ex){
            ex.printStackTrace();
            throw ex;

        }
        return st.getName();
    }

}
