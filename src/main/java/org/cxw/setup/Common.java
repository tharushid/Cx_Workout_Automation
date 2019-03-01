package org.cxw.setup;

import java.sql.Timestamp;
import java.util.UUID;

public class Common {


    public String getCurrentTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String currentDateTime = timestamp.toString();
        return currentDateTime.substring(0, 19);
    }

    public String getLaterTimeStampinDates(int dates) {
        long datestoIncrease = dates * 86400000;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setTime(timestamp.getTime() + datestoIncrease);
        String currentDateTime = timestamp.toString();
        return currentDateTime.substring(0, 19);
    }

    public String getLaterTimeStampinSec(int sec) {
        long datestoIncrease = sec * 1000;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setTime(timestamp.getTime() + datestoIncrease);
        String currentDateTime = timestamp.toString();
        return currentDateTime.substring(0, 19);
    }


    public UUID generateUUID() {
        UUID idOne = UUID.randomUUID();
        return idOne;
    }


}
