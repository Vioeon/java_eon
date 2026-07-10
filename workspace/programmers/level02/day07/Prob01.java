package level02.day07;

public class Prob01 {
    public String solution(String my_string, String letter) {
        String answer = my_string;

        answer = answer.replace(letter, "");

        return answer;
    }

    void main(){
        System.out.println(solution("banana", "a"));}
}
