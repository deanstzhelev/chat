package com.deanzhelev.chat;

import com.deanzhelev.chat.converter.MessageTypeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableJpaAuditing
public class AppConfig extends WebMvcConfigurationSupport{

    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService f = super.mvcConversionService();
        f.addConverter(new MessageTypeConverter());
        return f;
    }
}
