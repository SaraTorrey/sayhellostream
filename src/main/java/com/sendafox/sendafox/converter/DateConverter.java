package com.sayhellostream.sayhellostream.converter;


import com.sayhellostream.sayhellostream.util.Constants;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public final class DateConverter implements Converter<String, LocalDate> {

    @Override public LocalDate convert(String source ) {

        final DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.DATE_FORMAT );

        return dtf.parseLocalDate( source );
    }
}