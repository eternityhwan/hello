package osc.hello.member;

public class MemberServiceImpl implements MemberService {
    // 가입을 하고 조회를 하려면 레파지토리 인터페이스가 필요해
    // 레파지토리 인터페이스만 가져오면 nullpoint exception 에러 난다.
    // MemoryMemberRepository를 생성자로 선언해줘야해.
//   private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        // 메모미 맴버 리포지토리 코드가 하나도 없음, DIP를 잘 지킴, AppConfig에서 통제함, 생성자 주입이다.
    }

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
// 의존관계가 인터페이스뿐 아니라 구현까지 모두 의존하는 문제점이 있다.
// MemberServiceImpl 클래스는 인터페이스 MemberService를 의존함.
// 그런데 오른쪽에 구현체인 MemoryMemberRepository도 의존함, 추상화도 의존하고 구체화에도 의존한다
// 둘 다 의존하니까 문제?
// MemoryMemberRepository를 이 클래스가 알고 있는게 문제임, 갈아 끼울 수가 없어.