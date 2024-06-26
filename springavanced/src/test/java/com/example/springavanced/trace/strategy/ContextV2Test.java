package com.example.springavanced.trace.strategy;

import com.example.springavanced.trace.strategy.code.strategy.*;
import com.example.springavanced.trace.template.code.AbstractTemplate;
import com.example.springavanced.trace.template.code.SubClassLogic1;
import com.example.springavanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}

