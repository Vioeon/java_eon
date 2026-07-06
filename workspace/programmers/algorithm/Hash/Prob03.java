package algorithm.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Prob03 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        for(String phone : phone_book){
            map.put(phone, map.getOrDefault(phone, 0));
        }
        for(int i=0; i<map.size(); i++){
            for(int j=1; j<map.size(); j++){

            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            for(Map.Entry<String, Integer> entry1 : map.entrySet()) {
//                if (entry.containsKey(entry.getKey())) {
//                    map.replace(entry.getKey(), 1);
//                    answer = false;
//                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return answer;
    }

    void main(){
        String[] s = new String[]{"119", "97674223", "1195524421"};

        System.out.println((solution(s)));
    }
}
