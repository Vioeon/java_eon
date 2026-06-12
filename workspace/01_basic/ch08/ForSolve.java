package ch08;

public class ForSolve {
    public static void main(String[] args) {
        // 1 ~ 100 합계
        int sum = 0;

        for(int i=1; i<=100; i++){
            sum += i;
        }
        System.out.println("1~100 합계: " + sum);

        // 1 ~ 100 홀수 합계
        int oddSum = 0;

        for(int j=1; j<=100; j++){
            if(j%2 != 0){
                oddSum += j;
            }
        }
        System.out.println("1~100 홀수 합계: " + oddSum);

        // 1 ~ 100 짝수 합계
        int evenSum = 0;

        for(int k=1; k<=100; k++){
            if(k%2 == 0){
                evenSum += k;
            }
        }
        System.out.println("1~100 짝수 합계: " + evenSum);
    }
}
