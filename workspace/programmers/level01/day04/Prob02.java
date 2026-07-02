package level01.day04;

public class Prob02 {
    public int solution(int number, int n, int m) {
        int answer = 0;
        if(number%n==0 && number%m==0){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
    void main(){
        solution(60, 2, 3);
    }
}
