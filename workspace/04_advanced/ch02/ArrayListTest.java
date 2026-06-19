package ch02;

import java.util.*;

public class ArrayListTest {
    void main() {
//        String[] fruits = new String[5];
//        fruits[0] = "바나나";
//        fruits[1] = "사과";
//        fruits[2] = "오렌지";
//        fruits[3] = "파인애플";
//        fruits[4] = "수박";

        //ArrayList<String> fruits = new ArrayList<>();
        //nkedList<String> fruits = new LinkedList<>();
        //Vector<String> fruits = new Vector<>();

        //HashSet<String> fruits = new HashSet<>();
        //TreeSet<String> fruits = new TreeSet<>();
        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        fruits.add("바나나");
        fruits.add("사과");
        fruits.add("오렌지");
        fruits.add("파인애플");
        fruits.add("수박");

        printFruit(fruits);
    }

    // 전달받은 과일 목록 출력
    void printFruit(String[] fruits) {
        for (String f : fruits) {
            System.out.println(f);
        }
        System.out.println(Arrays.toString(fruits));
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