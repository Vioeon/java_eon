package level02.day03;

import java.util.*;

/**
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록
 * solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.
 */
public class Prob04 {
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];

        int idx = 0;
        for(int i=1; i<=n; i+=2){
            if(i%2 == 1){
                answer[idx++] = i;
            }
        }
        return answer;
    }
    void main() {
        System.out.println(Arrays.toString(solution(10)));
    }
}
