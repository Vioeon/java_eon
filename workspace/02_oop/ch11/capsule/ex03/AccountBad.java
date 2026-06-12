package ch11.capsule.ex03;

public class AccountBad {
    // 잔고
    public int balance;

    // 입금
    public void deposit(int amount){
        this.balance += amount;
        System.out.println(amount + "원이 입금 되었습니다. 잔고는 " + balance + "원 입니다.");
    }

    // 출금 + 잔고 부족한지 체크
    public void withdraw(int amount){
        if (amount <= balance) {
            this.balance -= amount;
            System.out.println(balance + "원이 출금 되었습니다. 잔고는 " + balance + "원 입니다.");
        } else {
            System.out.println("잔고가 부족합니다. 잔고는 " + balance + "원 입니다.");
        }
    }
}
