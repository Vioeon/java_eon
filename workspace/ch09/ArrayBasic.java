package ch09;

public class ArrayBasic {
    public static void main(String[] args) {
        // score int 배열을 선언하고 생성(크기 3)
        int[] scores = new int[3];
        // names String 배열을 선언하고 생성(크기 3)
        String[] names = new String[3];
        // scores 배열의 각 요소에 값을 할당
        scores[0] = 10;
        scores[1] = 20;
        scores[2] = 30;
        // names 배열의 각 요소에 값을 할당
        names[0] = "aaa";
        names[1] = "bbb";
        names[2] = "ccc";
        // scores 배열의 두번째 요소값을 출력
        System.out.println("scores[1] : " + scores[1]);
        // names 배열의 모든 요소값을 출력
        System.out.println("names[0] : " + names[0]);
        System.out.println("names[1] : " + names[1]);
        System.out.println("names[2] : " + names[2]);

        for (int i=0; i<names.length; i++){
            System.out.println("names["+ i +"] : " + names[i]);
        }
    }
}
