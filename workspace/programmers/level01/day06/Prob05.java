package level01.day06;

import java.util.Arrays;

public class Prob05 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int last = queries[i][1];
            for(int j=start; j<=last; j++){
                int min = 1000000;//********************?
                if(arr[j] > queries[i][2]){
                    answer[i] = arr[j];
                    break;
                }
                if(answer[j] == 0){
                    answer[i] = -1;
                }
            }
        }
        return answer;
    }

    void main() {
        int[] n = new int[]{0, 1, 2, 4, 3}; // 393
        int[][] n1 = new int[][]{{0, 4, 2},{0, 3, 2},{0, 2, 2}};
        System.out.println(Arrays.toString(solution(n,n1)));
    }
}
