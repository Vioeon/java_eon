package ch11.capsule.ex01;

// 시험 결과를 관리하는 클래스
public class Score {
    int kor;
    int eng;
    int math;

    // 총점을 계산하여 반환하는 메소드
    private int sum(){
        return kor+eng+math;
    }

    // 평균을 계산해서 반환하는 메소드(소수 세째자리에서 반올림)
    double avg(){
        double avg = sum()/3.0;
        return (Math.round(avg * 100) / 100.0);
    }
}
