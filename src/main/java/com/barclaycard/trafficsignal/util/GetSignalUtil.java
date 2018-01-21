package com.barclaycard.trafficsignal.util;

import com.barclaycard.trafficsignal.vo.TrafficSignalRoadsVO;
import com.barclaycard.trafficsignal.vo.TrafficSignalSecondsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GetSignalUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetSignalUtil.class);

    public static List<TrafficSignalSecondsVO> currentTraffic(int seconds){
        LOGGER.debug("*********Inside currentTraffic() ***********");

        TrafficSignalSecondsVO second = null;
        TrafficSignalRoadsVO roads = null ;
        List<TrafficSignalSecondsVO> list  = new ArrayList<TrafficSignalSecondsVO>();
        int southNorth =0, eastWest=0, count =0, i =0;
        boolean isSN = true;
        do {
            second = new TrafficSignalSecondsVO();
            roads = new TrafficSignalRoadsVO();

            second.setSecond(i);
            roads.setEastBound(eastWest);
            roads.setWestBound(eastWest);
            roads.setNorthBound(southNorth);
            roads.setSouthBound(southNorth);
            second.setRoadsVO(roads);
            list.add(second);

            LOGGER.debug("seconds\tsouthNorth\tsouthNorth\teastWest\teastWest");
            i++;
            southNorth++; eastWest++;
            if (count == 3) {
                // Let's treat this as RED light, let's switch the green to Weaver Road
                isSN = !isSN;
                count = 0;
                continue;
            }
            // Let's move the vehicle based on the signal
            if ((count == 0 && (southNorth == 1 || eastWest == 1)) || (count > 0 && count < 3)) {
                if (isSN) {
                    southNorth--;
                } else {
                    eastWest--;
                }
            }
            count++;
            LOGGER.debug(i+"\t"+southNorth+"\t"+southNorth+"\t"+eastWest+"\t"+eastWest);
        } while (i <= seconds);
        LOGGER.debug("*************Exit from currentTraffic()***********");
        return  list;
    }

}
