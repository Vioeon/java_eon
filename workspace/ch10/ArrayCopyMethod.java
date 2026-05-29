package ch10;

import java.util.Arrays;

public class ArrayCopyMethod {

    // 전달받은 배열의 모든 요소를 출력
    static void printArr(int[] printarr, String aname) {
        System.out.print(aname + ": [");
        for (int elem : printarr) {
            System.out.print(elem + ", ");
        }
        System.out.println("]");
    }

    // 원본 배열과 복사 배열을 출력한 후 값을 수정하고 다시 출력한다.
    static void testArr(int[] oar, int[] sar) {
        printArr(oar,"원본배열");
        printArr(sar,"복사배열");

        sar[0] = 99; // 값 변경시 서로 영향을 받는다
        oar[0] = 88;

        System.out.println("- 값변경-");
        printArr(oar,"원본배열");
        printArr(sar,"복사배열");
    }

    public static void main(String[] args) {
        // 1. 얕은 복사
        int[] orig = {10, 20, 30};

        // 주소값을 복사
        int[] shal = orig; // original을 복사함

        // original, shallow의 모든 요소를 출력
        System.out.println("\n1. 얕은 복사");
        testArr(orig,shal);

        // 2. 깊은 복사 - 수동 복사 for문
        System.out.println("\n2.1 깊은 복사 - 수동 복사");
        // 배열의 초기화 작업은 배열 선언과 할께 써야함
        // 이미 선언된 변수에 새로운 배열을 할당하려면 new int[]{ }형태로 작성해야함
        orig = new int[]{10,20,30,40};
        shal = new int[orig.length]; // original과 동일한 크기의 배열 생성

        // for문으로 수동 복사
        for (int i = 0; i < orig.length; i++) {
            shal[i] = orig[i];
        }
        testArr(orig, shal);

        // 3. 깊은 복사 - System.arraycopy() 이용
        System.out.println("\n2.2 깊은 복사 - System.arraycopy()");
        orig = new int[]{10,20,30,40,50};
        int[] orig2 = new int[]{1,2,3,4,5,6,7,8};
        //shal = new int[orig.length];

        // (원본배열, 원본배열에서 복사시작할 인덱스, 대상배열, 대상배열에서 복사시작할 인덱스, 복사할 요소개수)
        System.arraycopy(orig, 1, orig2, 2, 2);

        testArr(orig, orig2);

        // 4. 깊은 복사 - Arrays.copyOf()
        System.out.println("\n2.3 깊은 복사 - Arrays.copyOf()");
        orig = new int[]{70,20,30,40,50};
        shal = Arrays.copyOf(orig, orig.length);

        testArr(orig, shal);
    }
}
