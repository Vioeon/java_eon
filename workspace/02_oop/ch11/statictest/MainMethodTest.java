package ch11.statictest;

public class MainMethodTest {
    public void instanceMethod(){
        System.out.println("인스턴스 메소드 호출.");
    }
    public static void staticMethod(){
        System.out.println("static 메소드 호출");
    }
    public static void main(String[] args) {
        // main 메소드에서 외부메소드를 호출하는 첫번째 방법
        // static 메소드 그냥 호출
        staticMethod();

        // 두번째 방법
        // 인스턴스를 생성한 후 인스턴스 메소드 호출
        MainMethodTest m = new MainMethodTest();
        m.instanceMethod();
    }

    // java 21 이후 가능
//    void main(){
//        staticMethod();
//        instanceMethod();
//    }
}
