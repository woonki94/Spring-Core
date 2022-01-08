package hello.core.member;

public interface MemberRepository {
    public void save(Member member);
    public Member findById(Long memberId);

}
