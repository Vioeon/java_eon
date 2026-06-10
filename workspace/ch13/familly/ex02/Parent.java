package ch13.familly.ex02;

// 상속, 다형성, instanceof 사용
// 추상클래스로 변경
// 1. new연산자를 통한 직접 객체 생성이 불가
// 2. 추상 메소드가 하나라도 있으면 반드시 추상 클래스로 선언해야 함
public abstract class Parent {
    String name;

    Parent(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " 음식을 먹는다.");
    }

    void play() {
        System.out.println(name + " 등산을 한다.");
    }

    void sleep() {
        System.out.println(name + " 꿀잠을 잔다.");
    }

    // 부모 관점에서는 구현할 내용이 없다.
    // 자식이 오버라이드해서 구현하기를 원함 (강제로 오버라이드 하도록 지정)
    // 추상클래스
    abstract void study();

}
