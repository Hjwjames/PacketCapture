package com.example.HjwJames.packetCapture.dao;

import com.example.HjwJames.packetCapture.bean.CaptureData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaptureDataDao {
     void insertOrUpdate_List(List<CaptureData> list);
     CaptureData getCaptureDateById(Integer id);
}
