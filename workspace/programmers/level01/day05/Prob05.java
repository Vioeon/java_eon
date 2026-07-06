package level01.day05;

import java.util.ArrayList;

public class Prob05 {
    public int solution(int[] num_list) {
        int answer = 0;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                a.append(num_list[i]);
            }else{
                b.append(num_list[i]);
            }
        }
        int i = Integer.parseInt(a.toString());
        int j = Integer.parseInt(b.toString());
        answer = i + j;
        return answer;
    }

    void main() {
        int[] n = new int[]{3, 4, 5, 2, 1}; // 393
        int[] n1 = new int[]{5, 7, 8, 3}; // 581
        System.out.println(solution(n));
    }
}
