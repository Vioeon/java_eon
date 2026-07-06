package level02.day04;

public class Prob02 {
    public int solution(int n) {
        int answer = 1;
        while((answer*6)%n != 0 ){
            answer++;
        }
        return answer;
    }

    void main() {
        System.out.println(solution(10));
    }
}
