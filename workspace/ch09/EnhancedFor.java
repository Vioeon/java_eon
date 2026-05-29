package ch09;

public class EnhancedFor {
    public static void main(String[] args) {
        int[] scores = {90, 80, 75}; // 3과목
//        int[] scores = {100, 80, 70, 88}; // 4과목

        int sum = 0; // 총점
        double avg = 0; // 평균

        // 과목 수와 상관없이 총점과 평균을 계산하라
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        // 향상된 for 문
//        for(int score : scores){
//            sum += score;
//        }
        avg = Math.round(((double)sum / scores.length) * 10) / 10.0;

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
