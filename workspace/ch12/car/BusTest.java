package ch12.car;

public class BusTest {
    public static void main(String[] args) {
        Bus mycar = new Bus("람보르기니", "10-2", "마을버스"
                , new String[]{"집", "고등학교", "시청"}, 1300, 15);

        mycar.start();
        mycar.speedUp();
        mycar.stop();
        System.out.println(mycar.getBusInfo());

        mycar.start();
        mycar.speedUp();
        mycar.stop();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        System.out.println(mycar.getBusInfo());

        mycar.start();
        mycar.speedUp();
        mycar.stop();
        mycar.leave();
        mycar.leave();
        mycar.leave();
        System.out.println(mycar.getBusInfo());


        Bus mycar1 = new Bus("롤스로이스", "110-2", "마을버스"
                , new String[]{"집", "고등학교", "시청"}, 1300, 15);
        mycar1.start();
        mycar1.speedUp();
        mycar1.stop();
        System.out.println(mycar1.getBusInfo());

        mycar1.start();
        mycar1.speedUp();
        mycar1.stop();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();
        System.out.println(mycar1.getBusInfo());

        System.out.println(Bus.getTotalMoney());
    }
}
