package ch13.supercar;

public class GasolineCar extends SuperCar {
    //    GasolineCar(){
//        super();
//    }
    GasolineCar(int zero100) {
        super(zero100);
    }

    @Override
    void move() {
        super.move();
        System.out.println("기름을 사용합니다.");
    }
}
