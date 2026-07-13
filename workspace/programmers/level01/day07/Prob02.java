package level01.day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob02 {
    public int[] solution(int l, int r) {
        int[] answer = {};
        // DFS(깊이 우선 탐색)?

        return answer;
    }
//    List<Integer> list = new ArrayList<>();
//
//    public int[] solution(int l, int r) {
//
//        dfs(5, l, r);
//
//        Collections.sort(list);
//
//        if (list.isEmpty()) {
//            return new int[]{-1};
//        }
//
//        return list.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    void dfs(long num, int l, int r) {
//
//        if (num > r) return;
//
//        if (num >= l) {
//            list.add((int) num);
//        }
//
//        dfs(num * 10, l, r);       // 뒤에 0 붙이기
//        dfs(num * 10 + 5, l, r);   // 뒤에 5 붙이기
//    }
    void main() {
//        boolean[] b = new boolean[]{true, false, false, true, true};
        System.out.println(solution(5,555));
    }
}
