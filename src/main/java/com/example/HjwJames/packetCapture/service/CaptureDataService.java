package com.example.HjwJames.packetCapture.service;

import com.example.HjwJames.packetCapture.bean.CaptureData;

import java.util.List;

public interface CaptureDataService {
    /**
     * 批量保存
     * @param captureData
     */
    public void batchSaveCaptureData(List<CaptureData> captureData);

    /**
     * 数据填补
     * @param captureData
     */
    public void dateSupplyment(String url,CaptureData captureData);
}
