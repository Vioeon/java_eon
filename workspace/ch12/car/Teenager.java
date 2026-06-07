package ch12.car;

public class Teenager extends Passenger{

    public Teenager(int age, String payMethod){
        super(age, payMethod);
//        System.out.println("나이 " + getAge() + "세 청소년입니다." + getPayMethod());
    }

    public double getDiscountRate(){ // 할인율
        return 0.4;
    }
}
