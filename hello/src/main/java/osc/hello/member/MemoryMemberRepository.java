package osc.hello.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
// 메모리 레파지토리이기 때문에 테스트용도로만 써야해
@Component
public class MemoryMemberRepository implements MemberRepository {
    // 저장소니까 맵이 있어야해 HashMap<>() 에 데이터가 저장될 것이다.
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
