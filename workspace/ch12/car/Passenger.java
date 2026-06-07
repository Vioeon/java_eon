package ch12.car;

public class Passenger {
    private int age; // 승객 나이
    private String payMethod; // 지불 방법
    private String ageGroup;

    public Passenger(int age, String payMethod) {
        this.age = age;
        this.payMethod = payMethod;
        if(age <= 6) {
            ageGroup = "영유아";
        }else if (age < 13) {
            ageGroup = "어린이";
        } else if (age < 19) {
            ageGroup = "청소년";
        } else if (age < 65) {
            ageGroup = "성인";
        } else {
            ageGroup = "노인";
        }
    }

    // 랜덤 승객 객체 생성
    static Passenger randomPassenger() {
        int age = (int) (Math.random() * 90) + 1; // 승객 연령
        int randomPay = (int) (Math.random() * 2) + 1; // 1 : 카드, 2 : 현금
        String payMethod = (randomPay == 1) ? "카드" : "현금";
//        System.out.println("랜덤 승객 => 승객 연령: " + age + ", 지불 방법: " + payMethod);

        if (age <= 6) {
            // 영유아
            return new Infant(age, "무료");
        } else if (age < 13) {
            // 어린이 63% 할인
            return new Child(age, payMethod);
        } else if (age < 19) {
            // 청소년 40% 할인
            return new Teenager(age, payMethod);
        } else if (age < 65) {
            // 성인
            return new Adult(age, payMethod);
        } else {
            // 노인, 성인과 같음
            return new Senior(age, payMethod);
        }
    }
    public double getDiscountRate(){  // 할인율
        return 0.0;
    }
    public int payment(int price, String payMethod) { // 승객 나이와 지불 방법에 따라 요금 지불
        int paymoney = (int)(price * (1 - getDiscountRate()));
        if(payMethod.equals("현금")){
            paymoney += 100; // 현금 지불 시 100원 추가요금
        }
        return paymoney;
    }

    public int getAge() {
        return age;
    }
    public String getPayMethod() {
        return payMethod;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
}
