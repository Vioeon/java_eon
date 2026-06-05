package ch12.family.ex02;

public class Daughter extends Parent{
    Daughter(String name){
        super(name);
    }
    void play(){
        System.out.println(name + " 코노에 간다.");
        doFaceMask();
    }

    // 마스크팩을 한다. 코노 이후에 무조건 하는경우 private로 외부 접근 차단
    private void doFaceMask(){
        System.out.println(name + " 마스크 팩을 한다.");
    }

}
