package level02.day06;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob04 {
    public String solution(String my_string, int n) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            for(int j=0; j<n; j++){
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }

    void main(){
//        int[] list = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution("hello", 3));
    }
}
