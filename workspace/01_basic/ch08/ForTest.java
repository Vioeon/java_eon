package ch08;

// 1부터 지정한 수까지의 합계를 구하시오.
public class ForTest {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += i;
            System.out.println("i: " + i + ", sum: " + sum);
        }

        System.out.println("1부터 " + num + "까지의 합계 : " + sum);
    }
}
