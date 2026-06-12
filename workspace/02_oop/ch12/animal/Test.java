package ch12.animal;

public class Test {
    public static void main(String[] args) {
        Dog haru = new Dog();
//        haru.eat(); // 부모에게 물려 받은 메소드
//        haru.bark(); // 자식에서 추가한 메소드

        animalCare(haru);

//        Notebook book = new Notebook();
//        animalCare(book);

        Cat c = new Cat();
        animalCare(c);
    }

    // 동물 관리 서비스
    static void animalCare(Animal a){
        // Animal.eat()를 호출하는 동일한 코드지만
        // 실제 생성된 객체의 오버라이딩 된 메소드가 호출됨
        a.eat();
        a.move();
        a.sleep();
    }
//    static void animalCare(Dog a){
//        a.eat();
//        a.sleep();
//        a.move();
//        a.bark();
//    }
//    static void animalCare(Cat a){
//        a.eat();
//        a.sleep();
//        a.move();
//        a.liquefy();
//    }
}
