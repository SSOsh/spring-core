package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {
    //interface 있네? -> jdk proxy
    // 그냥 구체클래스네? -> cglib
    // 특정 조건 맞을때만 프록시 부가기능 적용 -> Pointcut
    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        //concreteservice를 상속받아 프록시를 만들기때문에 강제 캐스팅 가능
        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();
    }
}
