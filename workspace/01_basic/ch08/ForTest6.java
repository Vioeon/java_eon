package ch08;

// 1~9 구구단
// 2 x 1 = 2 3 x 1 = 3
// 2 x 2 = 4 3 x 2 = 6
// ...
public class ForTest6 {
    public static void main(String[] args) {
        for (int i=1; i<=9; i++) {
            for (int j=2; j<=9; j++) {
                System.out.print(j + " x " + i + " = " + (j*i) + "\t");
            }
            System.out.println();
        }
    }
}
