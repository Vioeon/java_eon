package ch13.supercar;

public class DriveTest {
    public static void main(String[] args) {
        GasolineCar g = new GasolineCar(100);
        HybridCar h = new HybridCar(110);
        ElectricCar e = new ElectricCar(120);
        PlugInHybridCar p = new PlugInHybridCar(130);

        Driver d = new Driver();

        d.drive(g);
        d.drive(h);
        d.drive(e);
        d.drive(p);

    }
}
