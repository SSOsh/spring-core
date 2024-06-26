package com.example.springavanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;
}