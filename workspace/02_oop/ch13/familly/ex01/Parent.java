package ch13.familly.ex01;

// 상속, 다형성, instanceof 사용
public class Parent {
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
}
