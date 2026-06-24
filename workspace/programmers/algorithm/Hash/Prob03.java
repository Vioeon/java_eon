package algorithm.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Prob03 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        for(String phone : phone_book){
            map.put(phone, map.getOrDefault(phone, 0));
        }
        for(String key : map.keySet()){
//            if(key.contains(key..)){
//
//            }
        }

        return answer;
    }

    void main(){
        TreeSet<String> tree = new TreeSet<>();
        tree.add("119");
        tree.add("119283629");
        tree.add("11");

        System.out.println(tree);
    }
}
