package osc.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import osc.hello.member.Grade;
import osc.hello.member.Member;
import osc.hello.member.MemberService;
import osc.hello.member.MemberServiceImpl;



public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // 스프링빈은 applicationContext.getBean 메서드로 찾을 수 있어.
        // 코드가 더 복잡해진거 맞음, 스프링 컨테이너 무슨 장점이 있는거야? (ㄹㅇ 내 생각)

        Member member = new Member(1l, "nomukun", Grade.VIP);
        memberService.join(member);
        // 멤버서비스의 join 메소드 부르고 멤버 객체를 매개변수로 넣어봐
        // 그러면 제대로 들어간거야

        Member findMember = memberService.findMember(1l);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
