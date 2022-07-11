package osc.hello.member;
//Entity 임
public class Member {
    private Long id;
    private String name;
    private Grade grade;

    // 생성자를 만들어주고, 데이터를 가지고 오고 설정할 게터세터를 만들어주자.
    // 이게 도메인(해결하고자하는 문제 영역)이야.
    // 사용자의 요구사항에 따른 상위수준의 개발범위
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
