package ch11.capsule.ex03;

public class AccountTest {
    public static void main(String[] args) {
        Account myAccount = new Account();

        // 10000원 입금. 잔고 10000
        myAccount.deposit(10000);
        // 5000원 출금. 잔고 5000
        myAccount.withdraw(5000);
        // 잔고 부족. 잔고 5000
        myAccount.withdraw(10000);
    }
}
