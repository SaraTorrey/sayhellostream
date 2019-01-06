package com.sayhellostream;

import com.sayhellostream.converter.DateConverter;
import com.sayhellostream.converter.DateFormatter;
import com.sayhellostream.converter.DateTimeConverter;
import com.sayhellostream.converter.DateTimeFormatter;
import com.sayhellostream.converter.MoneyConverter;
import com.sayhellostream.converter.MoneyFormatter;
import com.sayhellostream.converter.TimeFormatter;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters( FormatterRegistry registry ) {

        registry.addConverter( new MoneyConverter() );
        registry.addFormatter( new MoneyFormatter() );

        registry.addConverter( new DateConverter() );
        registry.addFormatter( new DateFormatter() );

        registry.addFormatter( new TimeFormatter() );

        registry.addConverter( new DateTimeConverter() );
        registry.addFormatter( new DateTimeFormatter() );
    }
}