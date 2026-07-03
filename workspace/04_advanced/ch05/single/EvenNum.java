package ch05.single;

public class EvenNum {
    public void run(){
        System.out.println("짝수 출력 시작");

        // 1~10까지 홀수를 출력한다.
        for(int i=2; i<=10; i+=2){
            System.out.println("짝수 : " + i);
        }

        System.out.println("짝수 출력 종료");
    }
}
