package ch09;

public class ArrayMemory {
    public static void main(String[] args) {
        int age = 25;
        int[] score = new int[3];
        int[] scores = new int[3];
        int[] scores1 = new int[3];
        score[0] = 90;
        scores[0] = 80;
        scores1[0] = 80;
        System.out.println(score + " : " + score[0]);
        System.out.println(scores + " : " + scores[0]);
        System.out.println(scores1 + " : " + scores1[0]);
    }
}
