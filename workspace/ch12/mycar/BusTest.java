package ch12.mycar;

public class BusTest {
    public static void main(String[] args) {
        Bus mycar = new Bus("람보르기니", "10-2", "마을버스"
                , new String[]{"집", "고등학교", "시청"}, 1300, 15);

        mycar.start();
        mycar.speedUp();
        mycar.stop();
        for (int i = 0; i < 2; i++) {
            Passenger p = Passenger.randomPassenger(); // 랜덤 승객 객체 생성
            mycar.ride(p); // 승객 정보로 승차
        }
        System.out.println(mycar.getBusInfo());

        mycar.start();
        mycar.speedUp();
        mycar.stop();
        for (int i = 0; i < 3; i++) {
            Passenger p = Passenger.randomPassenger();
            mycar.ride(p);
        }
        System.out.println(mycar.getBusInfo());
        mycar.leave();
        mycar.leave();
        System.out.println(mycar.getBusInfo());

        // 버스2
        Bus mycar1 = new Bus("페라리", "110-2", "마을버스"
                , new String[]{"식당", "대학교", "레스토랑"}, 1500, 15);
        mycar1.start();
        mycar1.speedUp();
        mycar1.stop();
        for (int i = 0; i < 1; i++) {
            Passenger p = Passenger.randomPassenger();
            mycar1.ride(p);
        }
        System.out.println(mycar1.getBusInfo());

        mycar1.start();
        mycar1.speedUp();
        mycar1.stop();
        for (int i = 0; i < 4; i++) {
            Passenger p = Passenger.randomPassenger();
            mycar1.ride(p);
        }
        System.out.println(mycar1.getBusInfo());
        mycar1.leave();
        mycar1.leave();
        System.out.println(mycar1.getBusInfo());
    }
}
