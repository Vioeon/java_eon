public class Test {
    public static void hello() { // static 메소드 (정적 메소드, 클래스 메소드)
        System.out.println("안녕");
    }
    public static void main(String[] args) {
        Test.hello(); // 메소드 이름으로 호출
    }
}