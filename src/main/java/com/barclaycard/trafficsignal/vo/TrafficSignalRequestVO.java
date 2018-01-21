package com.barclaycard.trafficsignal.vo;
import javax.validation.constraints.Min;
public class TrafficSignalRequestVO {

    @Min(value = 0L, message = "The value must be positive")
    private Integer seconds;

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
