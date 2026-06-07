package ch12.car;

public class Bus extends Car{
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
    Bus(String model, String no, String type, String[] stations, int price, int maxPassenger){
        super(model);
        this.no = no;
        this.type = type;
        this.stations = stations;
        this.price = price;
        this.maxPassenger = maxPassenger;
    }
    public int getPrice(){
        return price;
    }
    public static int getTotalMoney(){
        return totalMoney;
    }
    // 승차
    void ride(Passenger p){
        if(passengerCount < maxPassenger){
            int payMoney = p.payment(price,p.getPayMethod()); // 승객이 지불할 요금

            passengerCount++;
            totalPassenger++;

            money += payMoney;
            totalMoney += payMoney;
            if(p.getAgeGroup().equals("영유아")){
                System.out.println(p.getAge() + "세 " + p.getAgeGroup() + " 1명이 " + p.getPayMethod() + "로 승차하였습니다.");
            }else {
                System.out.println(p.getAge() + "세 " + p.getAgeGroup() + " 1명이 " + p.getPayMethod() + "(으)로 " + payMoney + "원을 지불하고 승차하였습니다.");
            }
        }else{
            System.out.println("승차 인원이 초과되었습니다. 다음 버스를 타세요.");
        }
    }
    // 하차
    void leave(){
        passengerCount--;
        System.out.println("1명이 하차합니다.");
    }

    // 오버라이딩
    void stop(){
        super.stop();
        station++;
        if(station == stations.length){
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
    String getBusInfo(){
        return "버스 번호: " + no
                + ", 종류: " + type
                + ", 현재 위치: " + stations[station]
                + ", 남은 좌석: " + (maxPassenger-passengerCount)
                + ", 요금: " + price
                + ", 수익: " + money
                + ", [ 총 승차 인원: " + totalPassenger
                + ", 버스 전체 총 수익: " + getTotalMoney() + " ]";
    }
}
