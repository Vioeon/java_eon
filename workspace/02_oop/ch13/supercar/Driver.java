package ch13.supercar;

public class Driver {
    void drive(SuperCar car){
        car.move();

        if(car instanceof Chargeable) {
            Chargeable c = (Chargeable) car;
            c.charge();
        }
    }
}
