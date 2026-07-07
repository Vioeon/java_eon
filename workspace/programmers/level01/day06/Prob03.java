package level01.day06;

public class Prob03 {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        int startNum = numLog[0];
        for(int i=1; i<numLog.length; i++){
            if(numLog[i] > numLog[i-1]){
                answer.append((numLog[i]-numLog[i-1] == 1)? "w" : "d");
            }else{
                answer.append((numLog[i-1]-numLog[i] == 1)? "s" : "a");
            }
        }
        return answer.toString();
    }

    void main() {
        int[] list = new int[]{0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        System.out.println(solution(list));
    }
}
