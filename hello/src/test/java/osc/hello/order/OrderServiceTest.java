package osc.hello.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osc.hello.AppConfig;
import osc.hello.member.Grade;
import osc.hello.member.Member;
import osc.hello.member.MemberService;
import osc.hello.member.MemberServiceImpl;

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
        void createOrder () {
            long memberId = 1l;
            Member member = new Member(memberId, "memberA", Grade.VIP);
            memberService.join(member);

            Order order = orderService.createOrder(memberId, "itemB", 20000);
            Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
        }
    }



