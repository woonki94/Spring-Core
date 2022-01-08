package hello.core.member;

public class Member {
    private Long memberId;
    private Grade grade;
    private String name;

    public Member(Long memberId,String name, Grade grade) {
        this.memberId = memberId;
        this.grade = grade;
        this.name = name;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


}
