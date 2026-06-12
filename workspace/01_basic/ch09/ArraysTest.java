package ch09;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 8, 3, 4, 1, 0, 5, 2};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {2, 1, 3};
        int[] arr4 = {1, 2, 3};

        // 1. arr의 모든 요소 출력
        System.out.println("1. 배열 출력");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] : " + arr[i]);
        }
        System.out.println(Arrays.toString(arr));

        // 2. arr2와 arr3, arr2와 arr4의 모든 요소가 같은 값을 가지고 있는지 출력 (순서와 값 모두 일치)
        // arr2, arr3 다름
        // arr2, arr4 같음
        System.out.println("\n2. 동일한지 비교");
        System.out.println("arr2, arr3 : " + Arrays.equals(arr2, arr3));
        System.out.println("arr2, arr4 : " + Arrays.equals(arr2, arr4));


        // 3. arr 요소의 최소값과 최대값
        // 최대값 : 9
        // 최소값 : 0
        System.out.println("\n3. 최대값 최소값");
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);

//        Arrays.sort(arr);
//        System.out.println("최대값 : " + arr[arr.length-1]);
//        System.out.println("최소값 : " + arr[0]);

        // 4. arr의 요소를 오름차순으로 정렬
        System.out.println("\n4. 오름차순 정렬");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
