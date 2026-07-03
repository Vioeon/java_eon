package level01.day05;

public class Prob02 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        // 등차수열 a + (n - 1)d
        for(int i=1; i<=included.length; i++){
            if(included[i-1]){
                answer += a + (i - 1) * d;
            }
        }
        return answer;
    }

    void main() {
        boolean[] b = new boolean[]{true, false, false, true, true};
        System.out.println(solution(3,4,b)); // 37
    }
}
