package osc.hello.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osc.hello.discount.DiscountPolicy;
import osc.hello.member.MemberRepository;

@Component
public class OrderServiceAuto implements OrderService {

    private MemberRepository memberRepository; // final은 값이 있어야함.
    private DiscountPolicy discountPolicy;
     //필드를 수정할 때 값을 set 으로 사용함
    // 필드값을 직접 변경하지 않는고 메서드로 변경해라.
//    // 이게 자바 빈 규약, 직접 접근하지 말고 메서드 set,get을 가지고 접근해라
//    @Autowired // set 방식 빈 주입
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired // set 방식 빈 주입
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired // 생성자 방식 빈 주입. 생성자가 딱 한개만 있으면 @Autowired 생략해도 된다.
//    public OrderServiceAuto(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("memberRepository = " + discountPolicy);
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        return null;
    }
}
// 필드를 수정할 때 값을 set 으로 사용함
//    @Autowired // set 방식 빈 주입
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired // set 방식 빈 주입
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }