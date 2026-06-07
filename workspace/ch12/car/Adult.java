package ch12.car;

public class Adult extends Passenger{

    public Adult(int age, String payMethod){
        super(age, payMethod);
//        System.out.println("나이 " + getAge() + "세 성인입니다." + getPayMethod());
    }

    public double getDiscountRate(){ // 할인율
        return 0.0;
    }
}
