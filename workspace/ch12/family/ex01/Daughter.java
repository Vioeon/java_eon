package ch12.family.ex01;

public class Daughter {
    String name;

    Daughter(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(name + " 음식을 먹는다.");
    }
    public void play(){
        System.out.println(name + " 코노에 간다.");
    }
    public void sleep(){
        System.out.println(name + " 꿀잠을 잔다.");
    }
}
