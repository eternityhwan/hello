package osc.hello.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import osc.hello.member.Grade;
import osc.hello.member.Member;


public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 무조건 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum타입은 ==을 사용해서 비교한다
            // 멤버에서 등급을 가져와보고, VIP 면 디스카운트를 반환한다. 아니면 0를 반환(개발끝)
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
