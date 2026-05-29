package ch10;

public class MethodOverloading {

    // 배열 내부의 모든 요소 값들을 문자열로 변환
    // [34, 4, 45, 4, 5]
    static String toString(int[] arr) {
        String result = "[";
        for (int i=0; i<arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    static String toString(double[] arr) {
        String result = "[";
        for (int i=0; i<arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    static String toString(String[] arr) {
        String result = "[";
        for (int i=0; i<arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        int[] scores = {89, 78, 79};
        System.out.println(toString(scores));

        double[] scores2 = {12.0, 45.6};
        System.out.println(toString(scores2));

        String[] scores3 = {"haru", "namu", "brong"};
        System.out.println(toString(scores3));
    }
}
