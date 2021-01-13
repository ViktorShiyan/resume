package ru.viktorshiyan.data;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Данные для странички home
 */
@Component
public class DataForHome {
    Map dataMap = new HashMap();

    public DataForHome() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        //Header
        dataMap.put("stage", currentYear - 2017);
        dataMap.put("age", currentYear - 1991);
        dataMap.put("address", "644015 Omsk, Russia");
        dataMap.put("email", "me@viktorshiyan.ru");
        dataMap.put("phone", "+7-965-972-50-75");
        dataMap.put("site", "www.viktorshiyan.ru");
        dataMap.put("nation", "Russian");
    }

    public Map getDataMap() {
        return dataMap;
    }
}
