package level02.day06;

import java.util.Scanner;

public class Prob01 {
    public String solution(String my_string) {
        String answer = new StringBuilder(my_string).reverse().toString();

        return answer;
    }

    void main(){
        System.out.println(solution("jaron"));
    }
}
