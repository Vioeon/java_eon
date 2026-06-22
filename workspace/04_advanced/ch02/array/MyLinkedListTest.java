package ch02.array;

public class MyLinkedListTest {
    void main() {
        long start = System.currentTimeMillis();

        // 10개의 요소를 담을 수 있는 MyLinkedList 객체를 생성한다.
        MyLinkedList arr = new MyLinkedList();

        // MyLinkedList "데이터-0"부터 "데이터-4"까지의 문자열을 담는다.
        for(int i=0; i<10000; i++){
            arr.appendTo("데이터-" + i);
        }

        // MyLinkedList 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, ..., 데이터-4]
        System.out.println(arr);

        // MyLinkedList 0번째 요소를 출력한다. 데이터-0
        System.out.println(arr.get(0));

        // MyLinkedList 3번째 요소를 출력한다. 데이터-3
        System.out.println(arr.get(3));

        // index 2를 삭제한다.
        arr.remove(2);

        // MyLinkedList 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-3, 데이터-4]
        System.out.println(arr);

        // index 2에 데이터-5를 삽입한다.
        arr.appendTo(2,"데이터-5");

        // MyLinkedList 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4]
        System.out.println(arr);

        // 마지막 위치에 데이터-6을 추가한다.
        arr.appendTo("데이터-6");

        // MyLinkedList 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4, 데이터-6]
        System.out.println(arr);

        // MyLinkedList 담긴 요소의 객수를 출력한다
        System.out.println("갯수: " + arr.size());

        long end = System.currentTimeMillis();
        System.out.println("MyArray addFirst 소요 시간: " + (end-start) + "ms");
    }
}
