package level02.day05;

public class Prob01 {
    public int solution(int price) {
        int answer = 0;
        double a = 0;
        if(price >= 500000){
            a = 20;
        }else if(price >= 300000) {
            a = 10;
        }else if(price >= 100000){
            a = 5;
        }
        System.out.println(a);
        answer = (int)(price - (price * (a/100)));
        return answer;
    }

    void main(){
        System.out.println(solution(580000));
    }
}
