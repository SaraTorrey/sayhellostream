package com.sayhellostream.converter;

import com.sayhellostream.util.Constants;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public final class DateTimeFormatter implements Formatter<DateTime> {

    @Override public DateTime parse(String source, Locale locale ) throws ParseException {

        final org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern( Constants.DATE_TIME_FORMAT );
        return dtf.parseDateTime( source );
    }

    @Override public String print(DateTime localDate, Locale locale ) {

        return localDate.toString( Constants.DATE_TIME_FORMAT );
    }
}