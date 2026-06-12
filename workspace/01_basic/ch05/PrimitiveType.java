package ch05;

public class PrimitiveType {

    void main() {
        int age; // 변수 선언
        age = 25; // 변수에 값 할당
        System.out.println(age);
        age = 30;
        System.out.println(age);

        int score = 100; // 변수 선언과 동시에 할당
        System.out.println(score);

        byte b = 127;
        System.out.println(b);

        short s = 10000;
        System.out.println(s);

        int num = 1000000000;
        System.out.println(num);

        long bigNum = 1000000000000000000L;
        System.out.println(bigNum);

        double pi = 3.141592;
        System.out.println(pi);
        // 반지름이 5인 원의 넓이
        System.out.println(pi * 5 * 5);

        float shortPi = 3.14f;
        System.out.println(shortPi);
        // 반지름이 5인 원의 넓이
        System.out.println(shortPi * 5 * 5);

        boolean isGood = true;
        System.out.println(isGood);

        boolean isMan = false;
        System.out.println(isMan);

        char grade = 'A';
        System.out.println(grade);

        grade = 'B';
        System.out.println(grade);

        // 문자열: 2글자 이상의 문자들을 저장할 때 사용
        String firstName = "멋쟁이";
        String lastName = "사자처럼";
        System.out.println(firstName);
        System.out.println(lastName);

        // final : 상수 선언
        final double PI = 3.14;

        // 반지름이 5인 원의 넓이
        System.out.println(PI * 5 * 5);

//        PI = 3.141592; // 상수는 재할당 할 수 없음
        // 반지름이 4인 원의 넓이
        System.out.println(PI * 4 * 4);

    }
}