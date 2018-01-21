package com.barclaycard.trafficsignal.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class TrafficSignalRequestVO {

    @NotEmpty
    private Integer seconds;

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
