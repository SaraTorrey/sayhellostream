package com.sayhellostream.sayhellostream.converter;


import com.sayhellostream.sayhellostream.util.Constants;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public final class TimeFormatter implements Formatter<LocalTime> {

    @Override public LocalTime parse(String source, Locale locale ) throws ParseException {

        final DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.TIME_FORMAT );
        return dtf.parseLocalTime( source );
    }

    @Override public String print(LocalTime localTime, Locale locale ) {

        return localTime.toString( Constants.TIME_FORMAT);
    }
}