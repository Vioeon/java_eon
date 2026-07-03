package ch05.multi;

public class MultiThreadTest {
    void main()throws InterruptedException{
        System.out.println("main 시작");

        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        odd.start(); // Thread를 상속받아서 start 사용
        new Thread(even, "짝수 스레드").start();
        // 익명 클래스
        // Runnable 인터페이스를 구현하는 익명의 클래스
        // 1회성
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=3; i<=10; i+=3){
                    System.out.println("3의 배수: "  + i);
                }
            }
        }).start();
        // 람다식
        // 새로운 스레드가 나중에 실행할 작업"을 Thread에게 전달하는 역할
//        new Thread(()->{
//            for(int i=3; i<=10; i+=3){
//                System.out.println("3의 배수: "  + i);
//            }
//        });

//        Thread.sleep(1000*5);
//        odd.join();

        System.out.println("main 종료");
    }
}

/*
class Thread{
    Runnable task;

    Thread(){}

    Thread(Runnable r){
        task = r;
    }
    public void start(){
        // os로 부터 스레드를 할당받고
        // 스케줄러에 스레드를 등록하고
        // 등등....
        if(task == null){
            run();
        }else{
            task.run();
        }
    }
    public void run(){
        System.out.println("Thread의 run 실행.");
    };
}*/