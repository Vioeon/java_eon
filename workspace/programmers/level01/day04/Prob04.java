package level01.day04;

public class Prob04 {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String tmp = ineq + eq;

        switch (tmp){
            case ">=":
                answer = n>=m? 1 : 0;
                break;
            case "<=":
                answer = n<=m? 1 : 0;
                break;
            case ">!":
                answer = n>m? 1 : 0;
                break;
            case "<!":
                answer = n<m? 1 : 0;
                break;
            default: break;
        };
        return answer;
    }
    void main(){
        System.out.println(solution("<","=",20,50));
    }
}
