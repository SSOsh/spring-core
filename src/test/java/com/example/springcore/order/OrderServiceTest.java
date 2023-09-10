package com.example.springcore.order;

import com.example.springcore.AppConfig;
import com.example.springcore.discount.RateDiscountPolicy;
import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.setDiscountPolicy(new RateDiscountPolicy());
//        orderService.setMemberRepository(new MemoryMemberRepository());
//        //NPE나는게 정상
//        orderService.createOrder(1L, "itemA", 10000);
    }
}
