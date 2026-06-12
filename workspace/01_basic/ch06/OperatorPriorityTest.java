package ch06;

public class OperatorPriorityTest {
    public static void main(String[] args) {
        // 1. 산술 연산자 우선 순위: 곱셈 > 덧셈
        int result1 = 5 + 3 * 2;
        System.out.println("result1 (5 + 3 * 2) = " + result1);

        // 괄호는 1순위
        int result2 = (5 + 3) * 2;
        System.out.println("result2 ((5 + 3) * 2) = " + result2);

        // 2. 비교 연산 > 논리 연산
        boolean result3 = (10 > 5) && (3 < 1);
        System.out.println("result3 (10 > 5 && 3 < 1) = " + result3);

        int x = 7;
        int y = 25;
        double z = y / (double)x;
        System.out.println(z);
    }
}
