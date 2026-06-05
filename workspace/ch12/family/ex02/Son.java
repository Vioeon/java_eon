package ch12.family.ex02;

// son이 Parent의 필드와 메소드를 상속 받는다.
public class Son extends Parent{
    Son(String name){
        super(name); // 부모의 생성자 호출
    }

    // 오버라이딩
    public void play(){
        System.out.println(name + " 게임을 한다.");
    }
}
