package com.sayhellostream.sayhellostream.service.impl;


import com.sayhellostream.sayhellostream.converter.DateFormatter;
import com.sayhellostream.sayhellostream.converter.DateTimeFormatter;
import com.sayhellostream.sayhellostream.converter.MoneyFormatter;
import com.sayhellostream.sayhellostream.converter.TimeFormatter;
import com.sayhellostream.sayhellostream.service.ConversionService;
import org.apache.commons.lang.WordUtils;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    DateFormatter dateFormatter;
    @Autowired
    TimeFormatter timeFormatter;
    @Autowired
    DateTimeFormatter dateTimeFormatter;
    @Autowired
    MoneyFormatter moneyFormatter;

    @Override
    public String convert( Object object ) {

        if ( object instanceof LocalDate) {
            return dateFormatter.print((LocalDate) object, null );
        }
        else if ( object instanceof DateTime) {
            return dateTimeFormatter.print((DateTime) object, null );
        }
        else if ( object instanceof LocalTime) {
            return timeFormatter.print((LocalTime) object, null );
        }
        else if ( object instanceof Money) {
            return moneyFormatter.print( (Money) object, null );
        }
        else if ( object instanceof Enum ) {
            return WordUtils.capitalizeFully(object.toString().replace("_", " " ) );
        }
        else {
            return object == null ? "" : object.toString();
        }
    }
}