package com.eventostech.api.helpers;

import java.util.Date;

public interface Helpers {

    static String nullToEmpty(String text) {
        return text != null ? text : "";
    }

    static Date minDate(Date date) {
        return date != null ? date : new Date(0);
    }

    static Date maxDate(Date date) {
        return  date != null ? date : new Date();
    }
}
