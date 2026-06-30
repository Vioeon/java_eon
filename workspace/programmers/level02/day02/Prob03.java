package level02.day02;

public class Prob03 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int a = numer1*denom2 + numer2*denom1;
        int b = denom1 * denom2;

        int gcd = gcd(a, b);

        return new int[]{a/gcd, b/gcd};
    }
    // 유클리드 호제법 자료 참고 (최대 공약수 구하는법)
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    void main() {
        System.out.println(solution(1, 2, 3, 4));
    }
}
