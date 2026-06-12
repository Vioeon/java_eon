package ch09;

// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산
public class ScoreArrayTest {
    public static void main(String[] args) {
        int[] haruScore; // 1. 배열 선언
        haruScore = new int[3]; // 배열 생성(크기가 3), 12byte의 메모리(힙) 할당하고 그 주소를 반환
        haruScore[0] = 100;
        haruScore[1] = 90;
        haruScore[2] = 85;

        System.out.println("국어 : " + haruScore[0]);
        System.out.println("영어 : " + haruScore[1]);
        System.out.println("수학 : " + haruScore[2]);

        int sum = haruScore[0] + haruScore[1] + haruScore[2];
        double avg = sum/3.0;
        avg = Math.round(avg*10) / 10.0;

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
