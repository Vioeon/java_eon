package level01.day03;

public class Prob04 {
    public int solution(int a, int b) {
        int answer = 0;
        int i = Integer.parseInt("" + a + b);
        int j = Integer.parseInt("" + b + a);
        return Math.max(i, j);
    }

    void main() {
        System.out.println(solution(9, 91));
    }
}
