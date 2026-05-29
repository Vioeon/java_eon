package ch08;

import java.util.Random;

// 6이 나올때까지 주사위를 던져보자!!!
public class WhileTest3 {
    public static void main(String[] args) {

        int testCount = 0;
        while (testCount < 100) {
            int num = 0;
            int i = 0;


            while (num != 6) {
                // 주사위 던지기
                // Math.random(): 0이상 1미만의 무작위 double타입 숫자를 반환
                num = (int) (Math.random() * 6) + 1; // 0 ~ 5.999...에 +1하고 int변환하면 소수점이 사라져서 1~6의 값이 됨
//              System.out.println(num);
                i++;
            }
            testCount++;
            System.out.println(testCount + " : 반복 횟수" + i);
        }
    }
}
