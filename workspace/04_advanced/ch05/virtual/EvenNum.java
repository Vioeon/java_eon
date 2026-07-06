package ch05.virtual;

/**
 * Thread를 만드는 방법 2번
 * - Runnable을 구현한다.
 * - run 메소드를 오버라이딩 한다. (독립적인 Thread로 실행할 코드를 작성)
 */
public class EvenNum implements Runnable {
    public void run(){
        System.out.println(Thread.currentThread().getName() + " 출력 시작.");

        // 1~10까지 홀수를 출력한다.
        for(int i=2; i<=10; i+=2){
            System.out.println("짝수 : " + i);
        }

        System.out.println("짝수 출력 종료");
    }
}
