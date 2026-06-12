package ch11;

public class MemberTest {
    String id;

    public MemberTest(){}
    // 생성자 정의
    public MemberTest(String id){
        this.id = id;
    }

    void main() {
        MemberTest member = new MemberTest("yong");
        System.out.println("회원 아이디: " + member.id);

    }
}
