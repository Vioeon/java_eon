package ch07;

// 회원 등급에 따른 할인 혜택을 적용하는 예제
// A, 골드 등급 50% 할인
// B, 실버 등급 30% 할인
// C, 브론즈 등급 10% 할인
// D, 일반 등급: 0% 할인
public class SwitchTest2 {
    public static void main(String[] args) {
        int price = 10000; // 정상가
        int lastPrice = price; // 할인가
        char grade = 'C'; // 회원 등급
        int discountRate = 0; // 할인율(%)

        // if문 사용
        System.out.println("if문 사용");
        if (grade == 'A') {
            discountRate = 50;
        } else if (grade == 'B') {
            discountRate = 30;
        } else if (grade == 'C') {
            discountRate = 10;
        } else if (grade == 'D') {
            discountRate = 0;
        }
        //lastPrice = price * (100 - discountRate)/100;
        lastPrice = (int) (price * (1 - discountRate / 100.0)); // double을 int로 대입할때 명시적 형변환필요

        System.out.println("회원님은 " + grade + "등급 이므로 정상가 "
                + price + "원 에서 " + discountRate + "% 할인된 가격 " + lastPrice + "원 입니다.");


        // switch문 사용
        System.out.println("switch문 사용");

        switch (grade) {
            case 'A':
                discountRate = 50;
                break;
            case 'B':
                discountRate = 30;
                break;
            case 'C':
                discountRate = 10;
                break;
            case 'D':
                discountRate = 0;
                break;
        }
        lastPrice = (int) (price * (1 - discountRate / 100.0)); // double을 int로 대입할때 명시적 형변환필요

        System.out.println("회원님은 " + grade + "등급 이므로 정상가 "
                + price + "원 에서 " + discountRate + "% 할인된 가격 " + lastPrice + "원 입니다.");

        // switch문 2번째
        System.out.println("switch문 2");

        switch (grade) {
            case 'A' -> discountRate = 50;
            case 'B' -> discountRate = 30;
            case 'C' -> discountRate = 10;
            case 'D' -> discountRate = 0;
        }
        lastPrice = (int) (price * (1 - discountRate / 100.0)); // double을 int로 대입할때 명시적 형변환필요

        System.out.println("회원님은 " + grade + "등급 이므로 정상가 "
                + price + "원 에서 " + discountRate + "% 할인된 가격 " + lastPrice + "원 입니다.");

    }
}
