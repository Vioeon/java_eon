package ch11.statictest;

public class MathUtilTest {
    static void add10(int n1){ // 인스턴스 변수 안써서 static메소드 사용함
        System.out.println(n1 + 10);
    }
    int n2 = 20;
    void addN2(int n1){ // 인스턴스 변수 사용해서 객체가 필요함 - static 못씀
        System.out.println(n1 + n2);
    }

    public static void main(String[] args) {
        MathUtil m = new MathUtil();
//        m.PI = 3.14; // 상수이기 때문에 수정 불가

        // 반지름 5인 원의 넓이는 xx 입니다.
        double area = MathUtil.PI * 5 * 5;
        System.out.println("반지름 5인 원의 넓이는 " + area + " 입니다.");

        System.out.println("3 + 5 = " + MathUtil.add(3,5));
    }
}
