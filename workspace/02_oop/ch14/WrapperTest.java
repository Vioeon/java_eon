package ch14;

public class WrapperTest {
    public static void main(String[] args) {
        // 1. parseInt(), parseDouble(), parseBoolean() 등 문자열 파싱
        int num1 = Integer.parseInt("100");
        double num2 = Double.parseDouble("3.14");
        boolean bool = Boolean.parseBoolean("true");

        System.out.println(num1); // 100
        System.out.println(num2); // 3.14
        System.out.println(bool); // true

        // 2. valueOf(): 기본 타입을 래퍼 객체로 변환
        Integer wrapperInt = Integer.valueOf(500);
        System.out.println(wrapperInt); // 500

        // 3. 오토 박싱과 오토 언박싱
        Integer boxedNum = 200; // 오토 박싱
        int unboxedNum = boxedNum; // 오토 언박싱
        System.out.println(unboxedNum); // 200

        String[] sArr = {"Hello ", "Java "};
        int[] iArr = {1, 2, 4 ,6};

        Object[] oArr = {"Hello ", "Java", 4}; // Obejct타입시 오토박싱에의해 Integer객체가 저장되는거다
    }
}