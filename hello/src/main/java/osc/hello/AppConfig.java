package osc.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import osc.hello.discount.DiscountPolicy;
import osc.hello.discount.FixDiscountPolicy;
import osc.hello.discount.RateDiscountPolicy;
import osc.hello.member.MemberRepository;
import osc.hello.member.MemberService;
import osc.hello.member.MemberServiceImpl;
import osc.hello.member.MemoryMemberRepository;
import osc.hello.order.OrderService;
import osc.hello.order.OrderServiceImpl;
    // AppConfig는 생성한 객체 인스턴스를 생성자를 통해 주입(연결)해준다
    // AppConfig클래스에서 역할과 구현체 그림을 한 그림에 보여야함

@Configuration
public class AppConfig {

        @Bean // 스프링 빈은 @Bean 이 붙은 스프링 빈의 이름을 사용한다. @Bean (name = "mmm") 으루 변경가능, 기본은 메서드 이름으로 박힘
        public MemberService memberService() {
                System.out.println("call Appconfig.memberService");
            return new MemberServiceImpl(MemberRepository());
        }
        @Bean
        public MemberRepository MemberRepository() { // 컨트롤 알트 엠, 익스트렉트 했다.
                System.out.println("call Appconfig.MemberRepository");
            return new MemoryMemberRepository();
        }

        @Bean
        public OrderService orderService() {
                System.out.println("call Appconfig.orderService");
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
        // 생성자를 통해서 구현체 생성자를 통해 주입하고 있다,
        }
        @Bean
        public DiscountPolicy discountPolicy() { // 메서드 명을 보는 순간 역할, 구현 까지 보여야해, 리펙터링임
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

// 메모리맴버레파지토리 참조값을 넣어주면 된다.
// 이전에는 객체를 생성하고 인터페이스에 뭐가 들어가는지 멤버서비스 구현체에서 직접 지정해줬어.
// 배우가 담당 배우를 섭외하는 것과 같은 짓임
// 이제 그 역할을 AppConfig에서 해준다
// 구현체 MemberServiceImpl에서 메모리 맴버리포지토리를 지워주고 생성자를 만들어준다.
// Appconfig의 생성자에 MemberServiceimpl( new MemoryMemberRepository())
// 괄호 안에 사용할 구현체를 넣어주면된다
