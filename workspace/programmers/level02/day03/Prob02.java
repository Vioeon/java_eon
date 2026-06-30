package level02.day03;

import java.util.Arrays;

public class Prob02 {
    public int solution(int[] array) {
        Arrays.sort(array);
        int i = array.length/2;

        return array[i];
    }

    void main() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        solution(a);
    }
}
