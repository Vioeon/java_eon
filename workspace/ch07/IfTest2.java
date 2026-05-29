package ch07;

// 입력받은 월(month)의 마지막 날짜를 출력하세요.(윤달은 계산 안함)
public class IfTest2 {
    public static void main(String[] args) {
        int month = 5;
        int lastDay = 0;

        System.out.println("입력 받은 월의 마지막 날짜?");

        if (month < 1 || month > 12) {
            System.out.println("1~12 사이의 숫자만 가능합니다.");
            System.exit(0); // 프로그램 강제 종료 : 괄호안에 숫자는 내가 지정하는 상태코드, 쓸일없음
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            lastDay = 30;
        } else if (month == 2) {
            lastDay = 28;
        } else {
            lastDay = 31;
        }
        System.out.println(month + "월의 마지막 날짜는 " + lastDay + "일 입니다");
//        System.out.printf("%d월의 마지막 날짜는 %d일 입니다.", month,lastDay);

    }
}
