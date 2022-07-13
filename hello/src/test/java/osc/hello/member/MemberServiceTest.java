package osc.hello.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osc.hello.AppConfig;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
//    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given 이 매개변수가 주어졌을 때
        Member member = new Member(1l, "nomu", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1l);

        //then
        Assertions.assertThat(member).isEqualTo(findMember); // 에서트 코어에이피아이에 가져온 멤버가 똑같으면 제대로 짠거.
    }
}
// 순수 자바코드로 짜면 OCP, DIP 원칙을 지키지 않아.
