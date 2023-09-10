package com.example.springcore;

import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemoryMemberRepository;
import com.example.springcore.order.OrderService;
import com.example.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//수동으로 주입될 Configuration은 제외 Configuration이라고 붙은 애들은 원래 싹 다 주입될 수 있기 때문에 제외
//우리는 예제 코드를 살리기 위해 해당 방법 사용
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean
//    OrderService orderService() {
//        return new OrderServiceImpl();
//    }

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
