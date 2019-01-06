package com.sayhellostream.converter;


import com.sayhellostream.util.Constants;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public final class DateTimeConverter implements Converter<String, DateTime> {

    @Override public DateTime convert(String source ) {

        final DateTimeFormatter dtf = DateTimeFormat.forPattern( Constants.DATE_TIME_FORMAT );

        return dtf.parseDateTime( source );
    }
}