package ch12.car;

public class BusTest {
    public static void main(String[] args) {
        Bus mycar = new Bus("람보르기니", "10-2", "마을버스"
                , new String[]{"집", "고등학교", "시청"}, 1300, 15);

        mycar.start();
        mycar.speedUp(1);
        mycar.stop();
        mycar.ride(1);
        System.out.println(mycar.getBusInfo());

        mycar.start();
        mycar.speedUp(1);
        mycar.stop();
        mycar.ride(3);
        System.out.println(mycar.getBusInfo());
        mycar.leave(2);
        System.out.println(mycar.getBusInfo());

//        // 버스2
        Bus mycar2 = new Bus("전기버스", "3005-2", "광역버스"
                , new String[]{"김포시청", "발산역", "홍대역", "서울 시청"}, 3500, 45);
        mycar2.start();
//        mycar2.speedUp();
        mycar2.stop();
        mycar2.ride(1);
        System.out.println(mycar2.getBusInfo());

        mycar2.start();
//        mycar2.speedUp();
        mycar2.stop();
        mycar2.ride(2);
        System.out.println(mycar2.getBusInfo());
        mycar2.leave(2);
        System.out.println(mycar2.getBusInfo());

        System.out.println(mycar); // toString 오버라이딩해서 출력 가능하다.
        System.out.println(mycar2.toString());
    }
}
