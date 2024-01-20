package com.example.springavanced.app.v2;

import com.example.springavanced.trace.TraceStatus;
import com.example.springavanced.trace.hellotrace.HelloTraceV1;
import com.example.springavanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        }catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

        return "ok";
    }
}
