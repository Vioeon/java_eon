package level01.day03;

public class Prob05 {
    public int solution(int a, int b) {
        int answer = 0;
        int i = Integer.parseInt("" + a + b);
        int j = 2*a*b;
        return Math.max(i, j);
    }

    void main() {
        System.out.println(solution(2, 91));
    }
}
