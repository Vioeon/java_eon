package ch09;

import java.util.Scanner;

public class ArrayForTest4 {
    public static void main(String[] args) {
        System.out.println("단을 입력하세요.");

        Scanner sc = new Scanner(System.in);
        int dan = sc.nextInt();
        System.out.println("입력한 단 : " + dan);

        int[] result = new int[9];
        for(int i=0; i<result.length; i++){
            result[i] = dan * (i+1);
        }
        System.out.println(dan + "단 학습 완료!");

        // 0을 입력할 때까지 반복
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");
            int num = sc.nextInt();

            if (num != 0) {
                System.out.println(dan + " x " + num + " = " + result[num - 1]);
            } else if (num == 0) {
                isRunning = false;
            }
        }
        System.out.println("종료합니다.");
        sc.close();
    }
}
