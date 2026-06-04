package ch11.capsule.ex02;

// 시험 결과를 관리하는 클래스
public class Score {
    private int kor;
    private int eng;
    private int math;



    public Score(int kor, int eng, int math) {
        if (kor > 100 || kor < 0) {
            System.out.println("kor 값은 0~100 사이로 입력해야 합니다.");
        } else {
            this.kor = kor;
        }
        if (eng > 100 || eng < 0) {
            System.out.println("eng 값은 0~100 사이로 입력해야 합니다.");
        } else {
            this.eng = eng;
        }
        if (math > 100 || math < 0) {
            System.out.println("math 값은 0~100 사이로 입력해야 합니다.");
        } else {
            this.math = math;
        }
    }

    // Getter 메소드
    public int getMath(){
        return this.math;
    }
    // Setter 메소드
    public void setMath(int math){
        this.math = math;
    }
    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    // 총점을 계산하여 반환하는 메소드
    private int sum() {
        return kor + eng + math;
    }

    // 평균을 계산해서 반환하는 메소드(소수 세째자리에서 반올림)
    double avg() {
        double avg = sum() / 3.0;
        return (Math.round(avg * 100) / 100.0);
    }
}
