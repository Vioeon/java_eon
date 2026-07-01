package level01.day03;

public class Prob02 {
    public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder();
        for(String s : arr){
            answer.append(s);
        }
        return answer.toString();
    }

    void main() {
        String[] str = new String[]{"a", "b", "c"};
        System.out.println(solution(str));
    }
}
