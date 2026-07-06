package level02.day04;

public class Prob04 {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        for(int n : numbers){
            sum += n;
        }
        answer = sum / numbers.length;
        return answer;
    }

    void main() {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(list));
    }
}
