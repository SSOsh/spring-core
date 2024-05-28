package hello.aop.exam.aop;

import hello.aop.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class RetryAspect {
    // Throwable을 따로 빼는 이유는 보통 java 개발자들은 Exception까지만 본다. Throwable은 그보다 더 상위
    // java memory가 없는 등의 java 개발자가 당장 처리할 수 없는 영역
    @Around("@annotation(retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        log.info("[retry] {} retry={}", joinPoint.getSignature(), retry);
        int maxRetry = retry.value();

        Exception exceptionHolder = null;
        for(int retryCount = 1;retryCount <= maxRetry; retryCount++){
            try {
                log.info("[retry] try count={}/{}", retryCount, maxRetry);
                return joinPoint.proceed();
            }catch (Exception e) {
                exceptionHolder = e;

            }
        }
        throw exceptionHolder;
    }
}
