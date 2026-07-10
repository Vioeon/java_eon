package level02.day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob03 {
    // 최빈값 key 중복 불가, value 중복 가능
    // 중복된 번호의 갯수 카운트
    public int solution(int[] array) {

        int result = 0;

        // Key 중복 불가, Value 중복 가능
        Map<Integer, Integer> map = new HashMap<>();

        // 값을 key 갯수를 value에 넣음
        for(Integer num : array){
            map.put(num, map.getOrDefault(num, 0) + 1); // hello:2, world:1, java:1
        }

        int maxcnt = 0;
        for(Integer num : map.keySet()){
            if(map.get(num) > maxcnt){
                maxcnt = map.get(num);
                result = num;
            }else if(map.get(num) == maxcnt){
                result = -1;
            }
        }
        return result ;
    }
    void main() {
        int[] a = new int[]{1, 2, 3, 3, 3, 4}; // 3
        System.out.println(solution(a));
    }
}
