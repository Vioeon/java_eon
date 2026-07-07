package level01.day06;

public class Prob02 {
    public int solution(int n, String control) {
        int answer = 0;
        // w,a,s,d 의 개수에 따라 계산
        for(int i=0; i<control.length(); i++){
            switch (control.charAt(i)){
                case 'w':
                    n++;
                    break;
                case 'a':
                    n-=10;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n+=10;
                    break;
            }
        }
        answer = n;
        return answer;
    }

    void main() {
//        boolean[] b = new boolean[]{true, false, false, true, true};
        System.out.println(solution(0, "wsdawsdassw"));
    }
}
