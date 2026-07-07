package ch07;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorJUnitTest {
    private static Calculator calc;

    @BeforeAll // 모든 테스트 메서드가 실행되기 전에 딱 한 번만 실행
    static void setUp(){
        calc = new Calculator();
    }
//    @BeforeEach // 각 테스트 메서드가 실행되기 직전에 매번 실행
//    void setUp(){
//        calc = new Calculator();
//    }

    @Test
    @DisplayName("두 정수의 덧셈 검증 2, 3")
    void add(){
        int result = calc.add(2,3);
        // 예상값과 실제값의 일치 여부 비교
        assertEquals(5, result, "덧셈의 결과는 5이어야 함");
    }
    @Test
    @DisplayName("두 정수의 덧셈 검증 2, 4")
    void add_3_4(){
        int result = calc.add(3,4);
        // 예상값과 실제값의 일치 여부 비교
        assertEquals(7, result, "덧셈의 결과는 7이어야 함");
    }

    @Test
    @DisplayName("두 정수의 나눗셈 검증 10, 6")
    @Disabled
    void divide(){
        double result = calc.divide(10,6);
        // 예상값과 실제값의 일치 여부 비교
        assertEquals(1.67, result, "나눗셈의 결과는 1.67이어야 함");
    }
    @Test
    @DisplayName("0으로 나누기 테스트")
    void divide_byZero(){
        // 특정 비정상 시나리오에서 기대한 예외 발생 검증
        assertThrows(ArithmeticException.class, ()->{
            calc.divide(10,0);
        });
    }
}
