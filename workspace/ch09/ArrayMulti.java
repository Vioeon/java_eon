package ch09;

public class ArrayMulti {
    public static void main(String[] args) {
        // 1.다차원 배열(2행 3열
        int[][] matrix = new int[2][3];

        matrix[0][1] = 10;
        matrix[1][2] = 20;

        // 2.다차원 배열 생성(초기화와 동시에)
        int[][] matrix2 = {
                {10, 20, 30},
                {40, 50, 60, 70}
        };

        // 3.배열의 모든 요소 출력
        for(int i = 0; i < matrix2.length; i++){
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        // 향상된 for문으로 배열 출력 - 출력 형식을 직접 제어 가능
        for (int[] numArray : matrix2) {
            for (int num : numArray) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
}
