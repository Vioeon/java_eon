package level01.day06;

import java.util.Arrays;

public class Prob04 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for(int i=0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        answer = arr.clone();
        return answer;
    }

    void main() {
        int[] n = new int[]{0, 1, 2, 3, 4};
        int[][] n1 = new int[][]{{0, 3},{1, 2},{1, 4}};
        System.out.println(Arrays.toString(solution(n,n1)));
    }
}
