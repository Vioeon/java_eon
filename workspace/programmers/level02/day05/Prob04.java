package level02.day05;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob04 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        ArrayList<Integer> a = new ArrayList<>();
        for(int n : num_list){
            a.add(0,n);
        }
        for(int i=0; i<a.size(); i++){
            answer[i] = a.get(i);
        }
        return answer;
    }

    void main(){

        int[] list = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(list)));
    }
}
