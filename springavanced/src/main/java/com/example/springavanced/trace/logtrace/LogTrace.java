package com.example.springavanced.trace.logtrace;

import com.example.springavanced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String mesage);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
