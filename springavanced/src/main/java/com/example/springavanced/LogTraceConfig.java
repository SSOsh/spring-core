package com.example.springavanced;

import com.example.springavanced.trace.logtrace.FieldLogTrace;
import com.example.springavanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
