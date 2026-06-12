package ch11.capsule.ex02;

public class ScoreTest {
    public static void main(String[] args) {
        Score haru = new Score(100,90,85);

//        int haruSum = haru.sum();
//        System.out.println("하루의 총점: " + haruSum);

        double haruAvg = haru.avg();
        System.out.println("하루의 평균: " + haruAvg);

        haru.setMath(haru.getMath() + 5);

        haruAvg = haru.avg();
        System.out.println("수정된 평균: " + haruAvg);
    }
}

