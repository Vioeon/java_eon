package ch06;

public class OperatorTest {
    static void main() {
        int num1 = 5;
        int num2 = 28;
        int num3, num5;
        double num4;

        num3 = num2 * num1;
        num4 = num2 / (double)num1;
        num5 = num2 % num1;

        System.out.println("28 * 5 = " + num3);
        System.out.println("28 / 5 = " + num4);
        System.out.println("28 % 5 = " + num5);

        System.out.println("++5 = " + ++num1);
        System.out.println("6++ = " + num1++);
        System.out.println(num1);

        int a = 3;
        boolean b = (++a + 10) >= 14 && (2 + 3 * ++a) >= 10;
        System.out.println(b); // true
        System.out.println(a); // 5
    }
}
