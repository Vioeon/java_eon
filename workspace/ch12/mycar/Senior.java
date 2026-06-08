package ch12.mycar;

public class Senior extends Passenger {

    public Senior(int age, String payMethod){
        super(age, payMethod);
//        System.out.println("나이 " + getAge() + "세 노인입니다." + getPayMethod());
    }

    public double getDiscountRate(){ // 할인율
        return 0.0;
    }
}
