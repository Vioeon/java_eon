package ch10;

public class MethodTest {
    void add() {
        int n1 = 10;
        int n2 = 100;
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    void add100(int n1) {
        int n2 = 100;
        int sum = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + sum);
    }

    int getSum(int n1, int n2) {
        int sum = n1 + n2;
        return sum;
    }

    void main() {
        this.add();
        add();

        add100(20);
        add100(30);

        int result = getSum(70,80);
        System.out.println(result);
    }
}
