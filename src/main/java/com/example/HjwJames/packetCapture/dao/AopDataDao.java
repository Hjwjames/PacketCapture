package com.example.HjwJames.packetCapture.dao;

import com.example.HjwJames.packetCapture.bean.AopData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AopDataDao {
    public void insert(AopData aopData);
}
