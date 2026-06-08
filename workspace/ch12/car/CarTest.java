package ch12.car;

public class CarTest {

    void main() {
        Car mycar = new Car("람보르기니");
        mycar.speed = 100;

        mycar.start();
        mycar.speedUp(3);
        mycar.gearUp();
        mycar.speedUp(2);
        mycar.gearUp();
        mycar.speedUp(3);
        mycar.gearUp();
        mycar.speedUp(2);

        mycar.stop();
    }
}
