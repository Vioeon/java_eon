package ch14;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello"; // String Pool의 "Hello" 객체
        String s2 = new String("Hello"); // 힙 영역에 객체

        System.out.println(s1 == s2); // s1과 s2는 서로 다른 객체를 참조
        System.out.println(s1 == "Hello"); // 동일한 String Pool의 "Hello"객체
        System.out.println(s2 == "Hello"); // s2는 힙영역의 객체, "Hello"는 String Pool의 객체

        System.out.println(s1.equals(s2)); // equals는 문자열 내용 비교
        System.out.println(s1.equals("Hello")); // true
        System.out.println(s2.equals("Hello")); // true

        s1 += " World";
        s1 += " Java";
        s1 += " Program";

        System.out.println(s1);
    }
}
