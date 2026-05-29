package ch10;

// 세 과목의 총점과 평균을 계산하는 메서드
public class MethodSolve {
    // int[] 점수 배열을 전달받아서 총점을 반환하는 메서드
    static int sum(int[] Scores) {
        int total = 0;
        for (int i : Scores) {
            total += i;
        }
        return total;
    }

    // int[] 점수 배열을 전달받아서 평균을 반환(소수 포함)
    static double avg(int[] Scores) {
        int total = sum(Scores);
        double scoreAvg = (double) total / Scores.length;
        scoreAvg = Math.round(scoreAvg * 10)/10.0;

        return scoreAvg;
    }

    // int[] 점수 배열을 전달 받아서 총점, 평균을 출력
    static void printScore(int[] Scores) {
        int sum = sum(Scores);
        double avg = avg(Scores);

        System.out.println("총점: " + sum + ", 평균: " + avg);
    }

    // 세명의 전체 총점과 평균 계산
    static void printTotal(int[] a, int[] b, int[] c) {
        int aSum = sum(a);
        int bSum = sum(b);
        int cSum = sum(c);

        int totalSum = aSum + bSum + cSum;
        double totalAvg = (double)totalSum / (a.length + b.length + c.length);
        totalAvg = Math.round(totalAvg * 10) / 10.0;
        System.out.println("전체 총점: " + totalSum + ", 전체 평균: " + totalAvg);
    }

    public static void main(String[] args) {
        // haru는 국어, 영어, 수학 점수가 각각 80, 70, 56이다.
        // namu는 국어, 영어, 수학 점수가 각각 90, 77, 80이다.
        // brong는 국어, 영어, 수학 점수가 각각 100, 99, 88이다.

        // 이 셋의 총점과 평균을 구해서 출력

        int[] hScore = {80, 70, 56};
        int[] nScore = {90, 77, 80};
        int[] bScore = {100, 99, 88};

        printScore(hScore);
        printScore(nScore);
        printScore(bScore);

        printTotal(hScore,nScore,bScore);
    }
}
