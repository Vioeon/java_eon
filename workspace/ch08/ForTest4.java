package ch08;

import java.util.Scanner;

public class ForTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();

        System.out.println(n + " x " + a + " = " + n*a);
        for(int i=1; i<10; i++){
            System.out.println(n + " x " + i + " = " + n*i);
        }

        sc.close();
    }
}
