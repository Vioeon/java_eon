package ch06;

public class lambda {

    // 인터페이스를 직접 구현한 클래스 정의
    void test1() {
        class CalculatorImpl implements Calculator {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        }
        Calculator cal1 = new CalculatorImpl();
        System.out.println(cal1.add(10, 20));
    }

    // 익명 클래스로 클래스 선언과 동시에 객체를 생성
    void test2() {
        Calculator cal1 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(cal1.add(15, 20));
    }

    // 람다식
    Calculator test3() {
        final int defaultval = 10;
//        defaultval = 20; // 람다식에서 사용하는 변수는 final상수여야해서 수정 불가
        Calculator cal1 = (int a, int b) -> a + b + defaultval;
        System.out.println(cal1.add(20, 20));
        return cal1;
    }

    void main() {
        test1();
        test2();
        Calculator cal = test3();
        System.out.println(cal.add(11,12));
    }
}
