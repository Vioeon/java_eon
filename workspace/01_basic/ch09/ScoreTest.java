package ch09;

// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산
public class ScoreTest {
    public static void main(String[] args) {
        int kor = 100;
        int eng = 90;
        int math = 85;

        int sum = kor + eng + math; // 총점
        double avg = sum / 3.0; // 평균,, 91.666...
        //avg = Math.round(avg); // 소수 첫째자리 반올림, 92.0
        //avg = Math.round(avg * 10) / 10.0; // 소수 둘째자리 반올림, 91.7
        avg = Math.round(avg * 100) / 100.0; // 소수 셋째자리 반올림, 91.67

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
