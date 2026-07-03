package ch05.multi;

/**
 * Thread를 만드는 방법 1번
 * - Thread를 상속 받는다.
 * - run 메소드를 오버라이딩 한다. (독립적인 Thread로 실행할 코드를 작성)
 */
public class OddNum extends Thread {
    OddNum(){
        super("홀수 스레드");
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " 출력 시작.");

        // 1~10까지 홀수를 출력한다.
        for(int i=1; i<=10; i+=2){
            System.out.println("홀수 : " + i);
        }

        System.out.println("홀수 출력 종료");
    }
}
