package level01.day04;

public class Prob05 {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        return flag? a+b : a-b;
    }
    void main(){
        System.out.println(solution(-4,7,true));
    }
}
