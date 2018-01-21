package com.barclaycard.trafficsignal;

public class TrafficSignal {
    public static void main(String arg[]) {
        int i = 0, sn = 0, ew = 0, count = 0;
        // Let's start traffic light with signal from Snell Road
        boolean isSN = true;
        do {
            System.out.println(i+": N "+sn+" S "+sn+" W "+ew+" E "+ew);
            i++;
            sn++; ew++;
            if (count == 3) {
                // Let's treat this as RED light, let's switch the green to Weaver Road
                isSN = !isSN;
                count = 0;
                continue;
            }
            // Let's move the vehicle based on the signal
            if ((count == 0 && (sn == 1 || ew == 1)) || (count > 0 && count < 3)) {
                if (isSN) {
                    sn--;
                } else {
                    ew--;
                }
            }
            count++;
        } while (i <= 20);
    }
}
