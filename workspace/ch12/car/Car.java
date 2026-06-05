package ch12.car;

public class Car {
    // 필드
    String model;
    int speed;
    int gear;

    // 생성자는 오버로딩 가능함
    Car(String model){
        System.out.println("Car(String name) 생성자 호출");
        this.model = model;
    }

    // 10km/h 가속한다.
    void speedUp() {
        speed += 10;
        System.out.println("가속합니다. 현재 속도는 " + speed + "km/h 입니다.");
    }

    // 10km/h 감속한다.
    void speedDown() {
        speed -= 10;
        System.out.println("감속합니다. 현재 속도는 " + speed + "km/h 입니다.");
    }

    // 기어를 1단 올린다.
    void gearUp() {
        gear++;
        System.out.println("기어를 1단 올려서 " + gear + "단이 되었습니다.");
    }

    // 기어를 1단 내린다.
    void gearDown() {
        gear--;
        System.out.println("기어를 1단 내려서 " + gear + "단이 되었습니다.");
    }

    // 출발한다.
    void start() {
        System.out.println("\n" + model + " 출발합니다.");
        gearUp();
        speedUp();
    }

    // 멈춘다.
    void stop() {
        System.out.println("멈춥니다.");
        gear = 0;

        while (speed > 0) {
            speedDown();
        }
    }
}
