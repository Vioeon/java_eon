package level01.day05;

public class Prob04 {
    public int solution(int[] num_list) {
        int answer = 0;
        int a=1;
        int b=0;
        for(int i : num_list){
            a *= i;
            b += i;
        }
        b = b*b;
        if(a < b){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }

    void main() {
        int[] n = new int[]{3,4,5,2,1};
        int[] n1 = new int[]{5, 7, 8, 3};
        System.out.println(solution(n1));
    }
}
