package ch13.supercar;

import javax.swing.*;

public class ElectricCar extends SuperCar implements Chargeable{
//    ElectricCar(){
//        super();
//    }
    ElectricCar(int zero100){
        super(zero100);
    }

    @Override
    void move() {
        super.move();
        System.out.println("전기를 사용합니다.");
    }
    public void charge(){
        System.out.println("전기를 충전합니다.");
    }
}
