package level01.day05;

public class Prob01 {
    public String solution(String code) {
        String answer = "";
        StringBuilder r = new StringBuilder();
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            if(mode == 0){
                if(code.charAt(i) != '1'){
                    if(i%2==0){
                        r.append(code.charAt(i));
                    }
                }else{
                    mode = 1;
                }
            }
            // mode가 1일때
            else{
                if(code.charAt(i) != '1'){
                    if(i%2==1){
                        r.append(code.charAt(i));
                    }
                }else{
                    mode = 0;
                }
            }
        }
        answer = r.toString();
        return answer == ""? "EMPTY" : answer;
    }
    void main(){
        System.out.println(solution("abc1abc1abc")); // acbac
    }
}
