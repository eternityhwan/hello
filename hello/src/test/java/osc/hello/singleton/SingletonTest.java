package osc.hello.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import osc.hello.AppConfig;
import osc.hello.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출 할 때 마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출 할 때 마다 객체 생성성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 객체가 계속 생성되는거야, 메모리 낭비가 심하다
        // 때문에 객체가 딱 한 개만 생성되고 공유하도록 설계하는 것이 싱글톤 패턴이야.
        // 한 개의 객체만 생성하고 인스턴스를 공유하면 효율적이다.
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        //
    }

    @Test
    @DisplayName("싱큰톤 패턴 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        // 이렇게 하면 메모리 소모가 적어, 속도 빨라진다.
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
//        AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 위처럼 스프링컨테이너를 가져와서 스프링 빈으로 주입해도 싱글톤으로 쓸 수 있어.
        // 싱글톤과 관련된 코드가 하나도 없음에도 스프링 컨테이너를 사용하면 싱글톤으로 쓸 수 있다.
        // 해당 테스트 돌려보면 같은 객체에서 가져온다구, 스프링은 99% 싱글톤 방식으로 작동함 스코프를 쓰면 되긴하는데 추후 설명.
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 객체가 계속 생성되는거야, 메모리 낭비가 심하다
        // 때문에 객체가 딱 한 개만 생성되고 공유하도록 설계하는 것이 싱글톤 패턴이야.
        // 한 개의 객체만 생성하고 인스턴스를 공유하면 효율적이다.
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
