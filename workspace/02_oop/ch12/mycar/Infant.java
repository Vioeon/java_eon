package ch12.mycar;

public class Infant extends Passenger {

    public Infant(int age, String payMethod){
        super(age, payMethod);
//        System.out.println("나이 " + getAge() + "세 영유아입니다." + getPayMethod());
    }

    public double getDiscountRate(){ // 할인율
        return 1;
    }
}
