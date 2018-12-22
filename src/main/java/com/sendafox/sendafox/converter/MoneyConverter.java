package com.sayhellostream.sayhellostream.converter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

public final class MoneyConverter implements Converter<String, Money> {

    @Override public Money convert( String source ) {

        BigDecimal bigDecimal = new BigDecimal( source.replace( "$", "" ).replace( ",", "" ) );

        return Money.of( CurrencyUnit.USD, bigDecimal );
    }
}