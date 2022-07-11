package osc.hello;

import osc.hello.member.Grade;
import osc.hello.member.Member;
import osc.hello.member.MemberService;
import osc.hello.member.MemberServiceImpl;



public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1l, "nomukun", Grade.VIP);
        memberService.join(member);
        // 멤버서비스의 join 메소드 부르고 멤버 객체를 매개변수로 넣어봐
        // 그러면 제대로 들어간거야

        Member findMember = memberService.findMember(1l);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
