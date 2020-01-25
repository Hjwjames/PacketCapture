package com.example.HjwJames.packetCapture.service.impl;

import com.example.HjwJames.packetCapture.bean.CaptureData;
import com.example.HjwJames.packetCapture.dao.CaptureDataDao;
import com.example.HjwJames.packetCapture.enums.UrlEnums;
import com.example.HjwJames.packetCapture.service.CaptureDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抓取数据录入表
 */
@Service
public class CaptureDataServiceImpl implements CaptureDataService {
    @Autowired
    CaptureDataDao captureDataDao;

    @Override
    public void batchSaveCaptureData(List<CaptureData> captureData) {
        captureDataDao.insertOrUpdate_List(captureData);
    }

    @Override
    public void dateSupplyment(String url , CaptureData captureData) {
        if(UrlEnums.URLENUMSMAP.containsKey(url)){
            captureData.setSource(UrlEnums.URLENUMSMAP.get(url));
        }else{
            captureData.setSource(UrlEnums.URLENUMSMAP.get("UNKNOWN"));
        }
    }
}
