package osc.hello.order;

import osc.hello.discount.DiscountPolicy;
import osc.hello.member.Member;
import osc.hello.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // 주문 서비스는 두 가지가 필요. 맴버리포지토리에서 회원 찾고 디스카운트 폴리시가 있어야해
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 맴버는 멤버레파지토리에서 아이디를 찾는다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문을 만들어서 반환해주기만하면 주문 끝나.
    }
}
    // 인터페이스에만 의존하니까 dip에 맞음 근데 이게 작동을 안하지 않냐? 구현이 안되잖아.
    // 널포인트익셉션 에러나는데 DIP 어떻게 지키냐

    // 왼쪽이 추상클래스 의존 = 오른쪽이 구현 클래스 의존. // 두 가지 다 의존 하고 있어.
    // 추상 클래스에만 의존해야만 DIP를 잘 지킨거, 인터페이스에만 의존하게만 의존하게 하면된다!
    // 문제 해결하려면 누군가가 OrderServiceImpl에 DiscountPolicy 구현객체를 대신 생성하고 주입해주어야해.

    // 역할과 구현을 충실히 분리했음.
    // 고정 디스카운트와 레이트 디스카운트 구현 객체, 역할객체 인터페이스(DiscountPolicy) 이렇게 만들었다.
    // OCP, DIP 준수한것처럼 보이지만
    // OrderServiceImpl이 추상클래스(인터페이스)뿐아니라 구현클래스도 의존하고 있어.

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 할인 정책이 지금 Fix로 되어있는데
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률 변경으로 바꾸면 되는디?