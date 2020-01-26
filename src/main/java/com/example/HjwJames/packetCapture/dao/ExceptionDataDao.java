package com.example.HjwJames.packetCapture.dao;

import com.example.HjwJames.packetCapture.bean.ExceptionData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExceptionDataDao {
    public void insert(ExceptionData exceptionData);
}
