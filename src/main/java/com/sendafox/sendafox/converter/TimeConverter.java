package com.sayhellostream.sayhellostream.converter;

import com.sayhellostream.sayhellostream.util.Constants;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public final class TimeConverter implements Converter<String, LocalTime> {

    @Override public LocalTime convert(String source ) {

        final DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.TIME_FORMAT );

        return dtf.parseLocalTime( source );
    }
}