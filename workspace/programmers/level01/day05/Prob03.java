package level01.day05;

public class Prob03 {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if (a != b && b != c && a != c) {
            answer = a + b + c;
        }else if(a == b && b == c && a == c){
            answer = (a+b+c) * (a*a + b*b + c*c) * (int)(Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3));
        }else{
            answer = (a+b+c) * (a*a + b*b + c*c);
        }
        return answer;
    }

    void main() {
        System.out.println(solution(2, 6, 1)); // 37
    }
}
