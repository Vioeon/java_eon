package algorithm.Hash;

import java.util.*;

public class Prob02 {
    public int solution(int[] nums) {
        // 중복 번호 있어서 Map
        // 가장 많은 종류 => 중복 없이 니까 Set
        // 가장 많은 개수 반환
        int answer = 0;
        int maxCnt = nums.length / 2; // 최대 가져갈 수 있는 개수

        Map<Integer, Integer> map = new HashMap<>(); // <포켓몬 번호, 획득했는지 조건>

        // 포켓몬 카드 목록 <카드 번호, 개수>
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if(map.size() > maxCnt){
            answer = maxCnt;
        }else{
            answer = map.size();
        }

        return answer;
    }
}
