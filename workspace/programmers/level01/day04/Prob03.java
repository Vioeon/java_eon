package level01.day04;

public class Prob03 {
    public int solution(int n) {
        int answer = 0;
        if(n%2 == 1){
            for(int i=0; i<=n; i++){
                answer = i%2==1? answer+i : answer;
            }
        }else{
            for(int i=0; i<=n; i++){
                answer = i%2==0? answer+(i*i) : answer;
            }
        }
        return answer;
    }
    void main(){
        System.out.println(solution(7));
    }
}
