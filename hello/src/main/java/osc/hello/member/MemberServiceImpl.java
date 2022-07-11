package osc.hello.member;

public class MemberServiceImpl implements MemberService {

    // 가입을 하고 조회를 하려면 레파지토리 인터페이스가 필요해
    // 레파지토리 인터페이스만 가져오면 nullpoint exception 에러 난다.
    // MemoryMemberRepository를 생성자로 선언해줘야해.
   private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        // 멤버 리포지토리에 있는 save 메소드를 실행시킨다.
        // Member 클래스에 있는 member 객체를 쥐여서 보내라
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
