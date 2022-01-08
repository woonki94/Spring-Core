package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
   // 동시성 이슈 때문에 현업에서는 concurrentHashMap 을 사용한다.
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getMemberId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
