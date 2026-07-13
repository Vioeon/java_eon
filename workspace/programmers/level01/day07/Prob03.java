package level01.day07;

import java.util.Arrays;

public class Prob03 {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num-start_num+1];
        int a = 0;
        for(int i=start_num; i<=end_num; i++){
            answer[a] = i;
            a++;
        }
        return answer;
    }

    void main() {
        System.out.println(Arrays.toString(solution(3, 10)));
    }
}
