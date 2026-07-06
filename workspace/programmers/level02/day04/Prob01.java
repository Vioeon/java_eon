package level02.day04;

public class Prob01 {
    public int solution(int n) {
        int answer = 0;
        // 피자 총 7조각
        // 인원 수 n명
        // 최소 한 조각 이상 피자의 수
        answer = n/7 + (n%7 > 0? 1 : 0);
        return answer;
    }

    void main() {
        System.out.println(solution(15));
    }
}
