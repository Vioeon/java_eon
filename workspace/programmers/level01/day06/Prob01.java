package level01.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob01 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        int size = answer.length;
        int last = answer[size-2];
        int before = answer[size-3];
        if(last > before){
            answer[size-1] = last - before;
        }else{
            answer[size-1] = last * 2;
        }
        return answer;
    }
    void main(){
        int[] list = new int[]{2,1,6};
        System.out.println(Arrays.toString(solution(list)));
    }
}
