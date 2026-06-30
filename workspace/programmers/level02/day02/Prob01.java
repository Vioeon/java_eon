package level02.day02;

public class Prob01 {
    public int solution(int num1, int num2) {
        int answer = (int)((num1/(float)num2) * 1000);
        System.out.println(answer);
        return answer;

    }
    void main() {
        solution(3, 2);
    }
}
