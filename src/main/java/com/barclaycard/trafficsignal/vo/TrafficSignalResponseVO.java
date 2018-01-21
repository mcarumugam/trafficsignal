package com.barclaycard.trafficsignal.vo;

import java.util.List;

public class TrafficSignalResponseVO {


    protected List<TrafficSignalSecondsVO> seconds;
    private Integer status;
    private ServiceErrorVO errorVO;

    public List<TrafficSignalSecondsVO> getSeconds() {
        return seconds;
    }

    public void setSeconds(List<TrafficSignalSecondsVO> seconds) {
        this.seconds = seconds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ServiceErrorVO getErrorVO() {
        return errorVO;
    }

    public void setErrorVO(ServiceErrorVO errorVO) {
        this.errorVO = errorVO;
    }




}
