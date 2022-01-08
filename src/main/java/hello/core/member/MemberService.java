package hello.core.member;

public interface MemberService {
    public void join(Member member);

    Member findMember(Long memberId);
}
