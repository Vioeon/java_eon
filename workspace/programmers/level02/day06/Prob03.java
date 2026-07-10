package level02.day06;

import java.util.Arrays;

public class Prob03 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int a = 0, b = 0;
        for(int n : num_list){
            if(n%2==0){
                a++;
            }else{
                b++;
            }
        }
        answer[0] = a;
        answer[1] = b;
        return answer;
    }

    void main() {
        int[] list = new int[]{1,2,3,4,5};
        System.out.println((Arrays.toString(solution(list))));
    }
}
