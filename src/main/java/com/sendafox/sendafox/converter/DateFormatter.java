package com.sayhellostream.sayhellostream.converter;


import com.sayhellostream.sayhellostream.util.Constants;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;


@Service
public final class DateFormatter implements Formatter<LocalDate> {

    @Override public LocalDate parse(String source, Locale locale ) throws ParseException {

        final DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.DATE_FORMAT );
        return dtf.parseLocalDate( source );
    }

    @Override public String print(LocalDate localDate, Locale locale ) {

        return localDate.toString( Constants.DATE_FORMAT );
    }
}