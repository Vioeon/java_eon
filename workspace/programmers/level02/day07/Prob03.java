package level02.day07;

import java.util.Arrays;

public class Prob03 {
    public int solution(int n, int k) {
        int answer = 0;

        answer = n*12000 + (k - ((n>=10)? n/10 : 0)) * 2000;
        return answer;
    }

    void main() {
//        int[] list = new int[]{1,2,3,4,5};
        System.out.println(solution(10,3));
    }
}
