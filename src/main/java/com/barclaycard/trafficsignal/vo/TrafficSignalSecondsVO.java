package com.barclaycard.trafficsignal.vo;

public class TrafficSignalSecondsVO {

    private Integer second;
    private TrafficSignalRoadsVO roads;

    public Integer getSecond() {
        return second;
    }


    public void setSecond(Integer second) {
        this.second = second;
    }
    public TrafficSignalRoadsVO getRoads() {
        return roads;
    }

    public void setRoadsVO(TrafficSignalRoadsVO roads) {
        this.roads = roads;
    }

}
