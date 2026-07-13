package level01.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob05 {
    public int[] solution(int[] arr) {
        int[] result = {};
        List<Integer> stk = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(stk.size() == 0){
                stk.add(arr[i]);
            }else if(stk.getLast() < arr[i]){
                stk.add(arr[i]);
            }else if(stk.getLast() >= arr[i]){
                stk.removeLast();
                i--;
            }
        }
        result = stk.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    void main() {
        int[] n = new int[]{1,4,2,5,3}; // 393
        System.out.println(Arrays.toString(solution(n)));
    }
}
