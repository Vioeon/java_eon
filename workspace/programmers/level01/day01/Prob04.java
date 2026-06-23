package level01.day01;

import java.util.Locale;
import java.util.Scanner;

public class Prob04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String result = "";

        for(int i=0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                result += Character.toLowerCase(str.charAt(i));
            }else {
                result += Character.toUpperCase(str.charAt(i));
            }
        }
        System.out.println(result);
    }
}
