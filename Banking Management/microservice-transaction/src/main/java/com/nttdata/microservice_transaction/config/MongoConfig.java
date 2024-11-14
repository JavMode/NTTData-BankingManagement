package com.nttdata.microservice_transaction.config;

import com.nttdata.microservice_transaction.converter.OffsetDateTimeToStringConverter;
import com.nttdata.microservice_transaction.converter.StringToOffsetDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoConfig {
    @Bean
    public MongoCustomConversions customConversions(){
        return new MongoCustomConversions(List.of(new OffsetDateTimeToStringConverter(), new StringToOffsetDateTimeConverter()));
    }
}
