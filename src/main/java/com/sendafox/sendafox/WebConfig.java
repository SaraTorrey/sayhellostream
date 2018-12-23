package com.sayhellostream.sayhellostream;

import com.sayhellostream.sayhellostream.converter.DateConverter;
import com.sayhellostream.sayhellostream.converter.DateFormatter;
import com.sayhellostream.sayhellostream.converter.MoneyConverter;
import com.sayhellostream.sayhellostream.converter.MoneyFormatter;
import com.sayhellostream.sayhellostream.converter.TimeFormatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters( FormatterRegistry registry ) {

        registry.addConverter( new MoneyConverter() );
        registry.addFormatter( new MoneyFormatter() );
        registry.addConverter( new DateConverter() );
        registry.addFormatter( new DateFormatter() );
        registry.addFormatter( new TimeFormatter() );
    }
}