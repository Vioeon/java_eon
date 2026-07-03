package ch05.single;

public class SingleThreadTest {
    void main(){
        System.out.println("main 시작");

        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        odd.run();
        even.run();

        System.out.println("main 종료");
    }
}
