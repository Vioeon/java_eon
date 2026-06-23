package ch02;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;

public class MapTest {
    void main() {
        Map<String, String> fruits = new HashMap<>();
        //Map<String, String> fruits = new TreeMap<>(); // 자동 오름차순정렬
        //Map<String, String> fruits = new LinkedHashMap<>(); // 담은 순서대로 출력가능

        fruits.put("월","바나나");
        fruits.put("화","사과");
        fruits.put("수","오렌지");
        fruits.put("목","파인애플");
        fruits.put("수","수박");
        fruits.put("금","123");

        // value는 Object 형이므로 String으로 명시적 형변환해줘야 한다.
        String fridayFruit = fruits.get("금").toUpperCase();
        System.out.println("금요일 과일: " + fridayFruit);

        printFruit(fruits);
    }

    // 전달받은 과일 목록 출력
    void printFruit(String[] fruits) {
        for (String f : fruits) {
            System.out.println(f);
        }
        System.out.println(Arrays.toString(fruits));
    }
    void printFruit(Map<String,String> fruits){
        System.out.println("월 과일: " + fruits.get("월"));
        System.out.println("수 과일: " + fruits.get("수"));
        System.out.println("화 과일: " + fruits.get("화"));

        System.out.println("요일별 모든 과일 출력");
//        for(String key : fruits.keySet()){
//            System.out.println(key + " : " + fruits.get(key));
//        }

        // 키와 값을 entry로 세트로 불러오는 방법 ( 보통 안쓰는데 전체 확인할때 사용 )
        for(Map.Entry<String,String> entry : fruits.entrySet()){
            String key = entry.getKey();
            String fruit = entry.getValue();
            System.out.println(key + " : " + fruit);
        }
    }

    void printFruit(Collection<String> fruits) {
        for (String f : fruits) {
            System.out.println(f);
        }
        System.out.println(fruits);
    }

//    void printFruit(List<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }
//    void printFruit(Set<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }

//    void printFruit(ArrayList<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }
//    void printFruit(LinkedList<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }
//    void printFruit(Vector<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }
//    void printFruit(HashSet<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }
//    void printFruit(TreeSet<String> fruits) {
//        for (String f : fruits) {
//            System.out.println(f);
//        }
//        System.out.println(fruits);
//    }
}