package ch12.car;

import ch12.mycar.Passenger;

import java.util.Objects;

public class Bus extends Car {
    private int passengerCount; // 승객수
    private String no; // 버스 번호
    private String type; // 버스 타입
    private String[] stations; // 노선
    private int station; // 현재 위치
    private int price; // 승차비
    private int maxPassenger; // 최대 승객수
    private int money; // 현재까지의 수익
    private int totalPassenger; // 총 승차 인원
    private static int totalMoney; // 운영하는 모든 버스의 수익

    // 컴파일러에 의해서 자동으로 생성되는 기본 생성자 모습
    Bus(String model, String no, String type, String[] stations, int price, int maxPassenger) {
        super(model);
        this.no = no;
        this.type = type;
        this.stations = stations;
        this.price = price;
        this.maxPassenger = maxPassenger;
    }

    public int getPrice() {
        return price;
    }

    public static int getTotalMoney() {
        return totalMoney;
    }

    // 승차
    void ride(){
        if (passengerCount < maxPassenger) {
            passengerCount++; // 현재 승차인원
            totalPassenger++; // 누적 승차인원

            money += price; // 수익
            totalMoney += price; // 버스 전체 수익
            System.out.println(" 1명이 승차하였습니다.");
        } else {
            System.out.println("승차 인원이 초과되었습니다. 다음 버스를 타세요.");
        }
    }
    // 승차
    void ride(int n) {
        for(int i=0; i<n; i++){
            ride();
        }
    }

    // 하차
    void leave(){
        passengerCount--;
        System.out.println("1명이 하차합니다.");
    }
    // 하차
    void leave(int n) {
        for(int i=0; i<n; i++){
            leave();
        }
    }

    // 오버라이딩
    void stop() {
        super.stop();
        station++;
        if (station == stations.length) {
            station = 0;
        }
        System.out.println("< 이번정류장은 " + stations[station] + "입니다 >");
    }

    // 기다리는 버스가 몇 정거장 전에 있는가?
    int getStationsLeft() {
        int result = 0;
        return result;
    }

    // 버스의 현재 상태를 출력합니다.
    String getBusInfo() {
        return "버스 번호: " + no
                + ", 종류: " + type
                + ", 현재 위치: " + stations[station]
                + ", 남은 좌석: " + (maxPassenger - passengerCount)
                + ", 요금: " + price
                + ", 수익: " + money
                + ", [ 누적 승차 인원: " + totalPassenger
                + ", 모든 버스 수익 총합: " + totalMoney + " ]";
    }
    // 버스의 현재 상태를 출력한다.
    @Override
    public String toString() { // 오버라이딩
        return "버스 번호: " + no
                + ", 종류: " + type
                + ", 현재 위치: " + stations[station]
                + ", 남은 좌석: " + (maxPassenger - passengerCount)
                + ", 요금: " + price
                + ", 수익: " + money
                + ", [ 누적 승차 인원: " + totalPassenger
                + ", 모든 버스 수익 총합: " + totalMoney + " ]";
    }

    public boolean equals(Object o){
        if( o == null || getClass() != o.getClass()){
            return false;
        }
        Bus bus = (Bus) o;
        return Objects.equals(no, bus.no);
    }

    public int hashcode() {
        return Objects.hashCode(no);
    }

}
