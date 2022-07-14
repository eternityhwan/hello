package osc.hello.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import osc.hello.AppConfig;
import osc.hello.member.MemberRepository;
import osc.hello.member.MemberServiceImpl;
import osc.hello.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("MemberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = memberService.getMemberRepository();

        // 모두 같은 인스턴스를 참고 하고 있어
        System.out.println("memberService -> MemberRepository = " + memberRepository1);
        System.out.println("memberService -> MemberRepository = " + memberRepository2);
        System.out.println("MemberRepository = " + memberRepository);
        // 모두 같은 인스턴스를 참고 하고 있어
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
//        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
