package ch08;

import java.util.Scanner;

// 계산기
// 5 + 4 -> 5 + 4 = 9
// 4 * 2 -> 4 * 2 = 8
public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("*** 계산기 프로그램 ***");
        System.out.println("계산식을 입력하세요");

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        String x = sc.next();
        int n2 = sc.nextInt();

        String result = switch (x) {
            case "+" -> Integer.toString(n1 + n2);
            case "-" -> "" + (n1 - n2);
            case "*" -> "" + (n1 * n2);
            case "/" -> "" + ((double)n1 / (n2));
            default -> "수식에 오류가 있습니다.";
        };
        System.out.println(n1 + " " + x + " " + n2 + " = " + result);

    }
}
