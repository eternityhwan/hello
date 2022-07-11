package osc.hello.discount;

import osc.hello.member.Member;
//역할을 먼저 정의하는 인터페이스
public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */

    int discount(Member member, int price); // 할인 메서드 선언, 매개변수로 맴버를 넘기고 int price를 받아.
}
