package level01.day03;

public class Prob03 {
    public String solution(String my_string, int k) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<k; i++){
            answer.append(my_string);
        }
        return answer.toString();
    }

    void main() {
        System.out.println(solution("string", 3));
    }
}
