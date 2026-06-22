package ch02.array;

public class MyArrayTest {
    void main() {
        // 10개의 요소를 담을 수 있는 MyArray 객체를 생성한다.
        //MyArray arr = new MyArray();
        MyArray arr = new MyArray(5);

        // MyArray에 "데이터-0"부터 "데이터-4"까지의 문자열을 담는다.
        arr.append("데이터-0");
        arr.append("데이터-1");
        arr.append("데이터-2");
        arr.append("데이터-3");
        arr.append("데이터-4");

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, ..., 데이터-4]
        System.out.println(arr);

        // MyArray의 0번째 요소를 출력한다. 데이터-0
        System.out.println(arr.getElem(0));

        // MyArray의 3번째 요소를 출력한다. 데이터-3
        System.out.println(arr.getElem(3));

        // index 2를 삭제한다.
        arr.delete(2);

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-3, 데이터-4]
        System.out.println(arr);

        // index 2에 데이터-5를 삽입한다.
        arr.append(2,"데이터-5");

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4]
        System.out.println(arr);

        // 마지막 위치에 데이터-6을 추가한다.
        arr.append("데이터-6");

        // MyArray에 담긴 모든 요소를 출력한다. [데이터-0, 데이터-1, 데이터-5, 데이터-3, 데이터-4, 데이터-6]
        System.out.println(arr);

        // MyArray에 담긴 요소의 객수를 출력한다
        System.out.println("갯수: " + arr.size());
    }
}
