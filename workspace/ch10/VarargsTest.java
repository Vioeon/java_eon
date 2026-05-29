package ch10;

import java.util.Arrays;

public class VarargsTest {
    // int 2개의 합계를 출력하는 메소드
    void sum(int n1, int n2) {
        System.out.println("2.sum2 메소드 시작");
        int result = n1 + n2;
        System.out.println("3. " + n1 + " + " + n2 + " = " + result);
        System.out.println("4. sum2 메소드 종료");
    }

    // int 3개의 합계를 출력하는 메소드
    void sum(int n1, int n2, int n3) {
        System.out.println("5.sum3 메소드 시작");
        int result = n1 + n2 + n3;
        System.out.println("6. " + n1 + " + " + n2 + " + " + n3 + " = " + result);
        System.out.println("7. sum3 메소드 종료");
    }

    // int 4개의 합계를 출력하는 메소드
    void sum(int n1, int n2, int n3, int n4) {
        System.out.println("8.sum4 메소드 시작");
        int result = n1 + n2 + n3 + n4;
        System.out.println("9. " + n1 + " + " + n2 + " + " + n3 + " + " + n4 + " = " + result);
        System.out.println("10. sum4 메소드 종료");
    }

    // int n개의 합계를 출력하는 메소드
    void sum(int... nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        System.out.println("합계 : " + result);
    }
    void main() {
        System.out.println("1. main 메소드 시작");
        this.sum(10,20);
        sum(10,20,30);
        sum(10,20,30,40);
        sum(10,20,30,40,50,60,70,80,90,100,101);
        System.out.println("11. main 메소드 종료");
    }
}
