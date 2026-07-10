package level02.day07;

public class Prob04 {
    public int solution(int n) {
        int answer = 0;
        for(int i=0; i<=n; i++){
            if(i%2==0){
                answer += i;
            }
        }
        return answer;
    }

    void main(){
//        int[] list = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(10));
    }
}
