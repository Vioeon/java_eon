package ch08;

public class ForTest7 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<=100; i++){
            if (i % 2 == 0) {
                continue; // 다음 턴 으로 넘어감
            }
            sum += i;
        }
        System.out.println("1~100 홀수 합계: " + sum);

        // 1~100 합계
        int num = 1;
        sum = 0;
        while (true) {
            sum += num;
            num++;
            if(num>100)
                break; // while문 중단
        }
        System.out.println("1~100 합계 : " + sum);
    }
}
