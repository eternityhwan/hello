package osc.hello;

import osc.hello.member.Grade;
import osc.hello.member.Member;
import osc.hello.member.MemberService;
import osc.hello.member.MemberServiceImpl;
import osc.hello.order.Order;
import osc.hello.order.OrderService;
import osc.hello.order.OrderServiceImpl;

// 오더 테스트 클래스
public class OrderApp {
    // 메인메서드로 테스트하는 것은 그다지 좋은 것은 아니야.
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(); // 구현화된 맴버 클래스 가져온다.
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "nomukun", Grade.VIP);
        memberService.join(member); // 맴버 서비스로 매모리 객체에 넣어야 쓸 것이다.

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("Order = " + order);
    }
}
