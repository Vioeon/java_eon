package ch05.virtual;

public class MultiThreadTest {
    void main()throws InterruptedException{
        System.out.println("main 시작");
        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        // 가상스레드
        Thread oddThread = Thread.ofVirtual().start(odd);
        Thread evenThread = Thread.ofVirtual().start(even);

        // Runnable 인터페이스를 구현하는 익명의 클래스
        Thread t3 = Thread.ofVirtual().start(new Runnable() {
            @Override
            public void run() {
                for(int i=3; i<=10; i+=3){
                    System.out.println("3의 배수: "  + i);
                }
            }
        });
        oddThread.join();
        evenThread.join();
        t3.join();

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