package level02.day04;

public class Prob03 {
    public int solution(int slice, int n) {
        int answer = 1;
        // 2~10 조각
        while((answer*slice) < n){
            answer++;
        }
        return answer;
    }

    void main() {
        System.out.println(solution(4, 12));
    }
}
