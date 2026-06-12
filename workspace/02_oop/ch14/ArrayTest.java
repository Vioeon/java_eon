package ch14;

import java.util.Arrays;

class ResizeableArray{
    private String[] elements;
    private int size;

    // 초기 용량을 전달해서 객체를 생성
    public ResizeableArray(int initialCapacity){
        elements = new String[initialCapacity];
        size = 0;
    }

    // 배열의 마지막에 해당 요소 추가
    public void add(String elem){
        if(size == elements.length){
            // 배열 늘리기 (2배 증가)
            String[] tempList = new String[elements.length * 2];
            for(int i=0; i<elements.length; i++){
                tempList[i] = elements[i];
            }
            elements = tempList;
        }
        elements[size] = elem;
        size++;
    }
    public String get(int i){
        return elements[i];
    }
    public int size(){
        return elements.length;
    }

    public String toString(){
        return Arrays.toString(elements);
    }

}
public class ArrayTest {
    public static void main(String[] args) {
        // 배열 생성
        ResizeableArray list = new ResizeableArray(2);

        // 배열에 데이터 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Orenge");

        System.out.println("인덱스 1의 요소 : " + list.get(1));
        System.out.println(list);
    }
}
