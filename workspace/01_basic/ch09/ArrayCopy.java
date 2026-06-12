package ch09;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        // 1. 얕은 복사
        int[] orig = {10, 20, 30};

        // 주소값을 복사
        int[] shal = orig; // original을 복사함

        // original, shallow의 모든 요소를 출력
        System.out.println("1. 얕은 복사");
        for (int i = 0; i < orig.length; i++) {
            System.out.println("original: " + orig[i] + "\tshallow: " + shal[i]);
        }

        shal[0] = 99; // 값 변경시 서로 영향을 받는다
        System.out.println("--- shal[0] = 99 ---");
        for (int i = 0; i < orig.length; i++) {
            System.out.println("original: " + orig[i] + "\tshallow: " + shal[i]);
        }

        // 2. 깊은 복사 - 수동 복사 for문
        System.out.println("2. 깊은 복사 - 수동 복사");
        // 배열의 초기화 작업은 배열 선언과 할께 써야함
        // 이미 선언된 변수에 새로운 배열을 할당하려면 new int[]{ }형태로 작성해야함
        orig = new int[]{10,20,30,40};
        shal = new int[orig.length]; // original과 동일한 크기의 배열 생성

        // for문으로 수동 복사
        for (int i = 0; i < orig.length; i++) {
            shal[i] = orig[i];
        }
        for (int i = 0; i < orig.length; i++) {
            System.out.println("original: " + orig[i] + "\tshallow: " + shal[i]);
        }

        shal[0] = 1; // 서로 영향을 받지 않는다.
        System.out.println("--- shal[0] = 1 ---");
        for (int i = 0; i < orig.length; i++) {
            System.out.println("original: " + orig[i] + "\tshallow: " + shal[i]);
        }

        // 3. 깊은 복사 - System.arraycopy() 이용
        System.out.println("3. 깊은 복사 - System.arraycopy()");
        orig = new int[]{10,20,30,40,50};
        int[] orig2 = new int[]{1,2,3,4,5,6,7,8};
        //shal = new int[orig.length];

        // (원본배열, 원본배열에서 복사시작할 인덱스, 대상배열, 대상배열에서 복사시작할 인덱스, 복사할 요소개수)
        System.arraycopy(orig, 1, orig2, 2, 2);

        for (int i = 0; i < orig.length; i++) {
            System.out.println("original: " + orig[i] + "\tshallow: " + orig2[i]);
        }

        // 4. 깊은 복사 - Arrays.copyOf()
        System.out.println("4. 깊은 복사 - Arrays.copyOf()");
        orig = new int[]{70,20,30,40,50};
        shal = Arrays.copyOf(orig, orig.length);

        for (int i = 0; i < orig.length; i++) {
            System.out.println("original: " + orig[i]);
        }
        for (int i = 0; i < shal.length; i++) {
            System.out.println("shallow: " + shal[i]);
        }
    }
}
