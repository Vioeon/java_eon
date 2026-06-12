package ch12.mycar;

public class Child extends Passenger {

    public Child(int age, String payMethod){
        super(age, payMethod);
//        System.out.println("나이 " + getAge() + "세 어린이입니다." + getPayMethod());
    }

    public double getDiscountRate(){ // 할인율
        return 0.63;
    }
}
