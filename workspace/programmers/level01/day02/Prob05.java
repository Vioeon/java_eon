package level01.day02;

import java.util.Scanner;

public class Prob05 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = my_string.substring(0,s) + overwrite_string + my_string.substring(overwrite_string.length()+s);
        return answer;
    }

    void main(String[] args) {
        solution("He11oWor1d", "lloWorl", 2);
    }
}
