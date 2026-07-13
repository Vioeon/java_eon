package level01.day07;

import ch14.ArrayListTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob04 {
    public int[] solution(int n) {
        int[] answer = {};
        int[] tmp = new int[1000];
        tmp[0] = n;
        int a=1;
        while(n != 1){
            if(n%2 == 0){
                n /= 2;
            }else{
                n = 3 * n + 1;
            }
            tmp[a] = n;
            a++;
        }
        answer = Arrays.copyOf(tmp,a);
        return answer;
    }

    void main() {
        System.out.println(Arrays.toString(solution(10)));
    }
}
