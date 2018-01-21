package com.barclaycard.trafficsignal.controller;

import com.barclaycard.trafficsignal.util.GetSignalUtil;
import com.barclaycard.trafficsignal.vo.ServiceErrorVO;
import com.barclaycard.trafficsignal.vo.TrafficSignalRequestVO;
import com.barclaycard.trafficsignal.vo.TrafficSignalResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping(value="/rest/trafficSignal")
public class TrafficSignalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficSignalController.class);

    GetSignalUtil signalUtil;

    @RequestMapping(value = "getSignal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrafficSignalResponseVO GetSignal(@Valid @RequestBody TrafficSignalRequestVO requestVO, BindingResult bindingResult){

        TrafficSignalResponseVO responseVO = new TrafficSignalResponseVO();

        if (null != bindingResult && bindingResult.hasErrors()) {
            ServiceErrorVO errorVO = new ServiceErrorVO();
            errorVO.setErrorCode(bindingResult.getFieldError().getCode());
            errorVO.setMessage(bindingResult.getFieldError().getDefaultMessage());
            responseVO.setErrorVO(errorVO);
        }else {
            LOGGER.debug("*********** Call GetSignal for the seconds = " + requestVO.getSeconds() + "************ ");
            ZonedDateTime processBeginTime= ZonedDateTime.now();
            responseVO.setSeconds(GetSignalUtil.currentTraffic(requestVO.getSeconds()));
            long duration = ChronoUnit.MILLIS.between(processBeginTime,ZonedDateTime.now());
            LOGGER.debug("Time Taken : {} in milli seconds for {} seconds to calculate the traffic",duration, requestVO.getSeconds());

        }
        return  responseVO;
    }

}
