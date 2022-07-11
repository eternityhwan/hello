package osc.hello.member;

import java.util.HashMap;
import java.util.Map;

        // 메모리 레파지토리이기 때문에 테스트용도로만 써야해
public class MemoryMemberRepository implements MemberRepository {
    // 저장소니까 맵이 있어야해
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
