package ch12.familly.ex01;

public class Son {
    String name;

    Son(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(name + " 음식을 먹는다.");
    }
    public void play(){
        System.out.println(name + " 게임을 한다.");
    }
    public void sleep(){
        System.out.println(name + " 꿀잠을 잔다.");
    }
}
