package com.sayhellostream.converter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Service
public final class MoneyFormatter implements Formatter<Money> {

    @Override public Money parse( String source, Locale locale ) throws ParseException {

        BigDecimal bigDecimal = new BigDecimal( source.replace( "$", "" ).replace( ",", "" ) );

        return Money.of( CurrencyUnit.USD, bigDecimal );
    }

    @Override public String print( Money money, Locale locale ) {

        if ( money == null ) {
            return "";
        }
        NumberFormat format =
                NumberFormat.getCurrencyInstance( Locale.US);

        return format.format(money.getAmount());
    }
}