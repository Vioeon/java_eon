package level02.day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob03 {
    // 최빈값 key 중복 불가, value 중복 가능
    // 중복된 번호의 갯수 카운트
    public int solution(int[] array) {

        int result;
//
//        // Hash 인데 Set은 중복 데이터 불가 이므로 Map사용해야 함
//        Map<String, Integer> map = new HashMap<>();
//
//        // 1. 참가자 명단 구성
//        for(String name : participant){
//            map.put(name, map.getOrDefault(name, 0) + 1); // hello:2, world:1, java:1
//        }
//
//        // 2. 완주 명단 제외
//        for(String name : completion){
//            map.put(name, map.get(name) - 1);
//        }
//
//        // 3. 미완주 선수 반환
//        for(String name : map.keySet()){
//            if(map.get(name) != 0){
//                result = name;
//            }
//        }
        int result;
    }
    void main() {
        int[] a = new int[]{5, 2, 3, 3, 3, 4};
        System.out.println(solution(a));
    }
}
