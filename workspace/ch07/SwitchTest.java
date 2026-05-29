package ch07;

public class SwitchTest {
    static void main(String[] args) {
        int month = 5;

        if (month < 1 || month > 12) {
            System.out.println("1~12 사이의 숫자만 가능합니다.");
            System.exit(0); // 프로그램 강제 종료 : 괄호안에 숫자는 내가 지정하는 상태코드, 쓸일없음
        }

        // v01
        switch (month) {
            case 4,6,9,11 -> System.out.println(month + "월의 마지막날은 30일 입니다.");
            case 2 -> System.out.println(month + "월의 마지막날은 28일 입니다.");
            default -> System.out.println(month + "월의 마지막날은 31일 입니다.");
        }

        // v02
        int date = switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 31;
        };
        System.out.println(month + "월의 마지막날은 " + date + "일 입니다.");
    }
}
