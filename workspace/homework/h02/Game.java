package homework.h02;

import java.util.Scanner;

// 05.29 과제 : 메소드로 코드 분리하기
public class Game {
    // 플레이어 스탯
    final int MAX_HP = 100; // 플레이어 기본 최대 체력
    final int MAX_EXP = 150; // 플레이어 필요 경험치량

    String playerName = "";
    int playerLevel = 1; // 플레이어 레벨
    int playerExp = 0; // 플레이어 경험치
    int playerHp = 100; // 플레이어 체력 ( 체력 고정 )
    int playerAtk = 10; // 플레이어 공격력 ( 레벨 당 공격력 *2 )
    int cntHeal = 1; // 회복 아이템 수량 ( 체력 10 회복 )
    int cntSmoke = 1; // 연막 아이템 수량 ( 도망가기 )
    int cntUlt = 1; // 궁극기 사용가능 횟수 ( 궁극기 데미지: atk * 5 )

    // 적 스탯
    int enemyHp = 0; // 적 체력
    int enemyAtk = 0; // 적 공격력

    int selMenu, selBattle; // 메뉴 선택 변수
    boolean isRunning = true; // 프로그램 실행 상태
    boolean isBattle = false; // 전투상태 확인

    Scanner sc = new Scanner(System.in);

    // 게임 상태 메소드
    public void startGame(){ // 게임 시작
        System.out.println("**************");
        System.out.println("** Text RPG **");
        System.out.println("**************\n");

        System.out.println(">> 퀘스트 : 지역을 탐색하며 캐릭터를 성장시키세요.\n");

        System.out.print("캐릭터 이름을 입력해주세요 : ");
        playerName = sc.next();
        System.out.println(playerName + "님 어서오세요. 게임을 시작합니다.\n");
    }
    public void exitGame() {
        System.out.println("[게임을 종료합니다.]\n");
        isRunning = false;
    }
    public int selectMenu() { // 메뉴 선택
        System.out.println("어떤 행동을 하시겠습니까?");
        System.out.println("1) 상태창  2) 탐색하기  0) 게임종료");
        selMenu = sc.nextInt();
        System.out.println("--------------------------------");

        return selMenu;
    }

    public void showStatus() { // 상태창
        System.out.println("[상태창]");
        System.out.println("이름 : " + playerName);
        System.out.println("레벨 : " + playerLevel + "\t\t\t 경험치 : " + playerExp + " / " + MAX_EXP);
        System.out.println("체력 : " + playerHp + " / " + MAX_HP + "\t 공격력 : " + playerAtk);
        System.out.println("보유 아이템 : 회복(x" + cntHeal + "), 연막(x" + cntSmoke + ")");
        System.out.println("궁극기 횟수 : " + cntUlt);
        System.out.println("--------------------------------");
    }  // 상태창
    public void explore(){ // 탐색
        System.out.println("[지역을 탐색합니다]\n");

        int event = (int) (Math.random() * 100); // 0~99 사이 랜덤 확률

        if (event < 60) { // 60%
            System.out.println("몬스터와 마주쳤습니다!");
            spwnEnemy();

            while (isBattle) {
                battleState(); // 배틀 정보 ( 플레이어 상태, 몬스터 상태 )
                selBattle = selectBattle(); // 플레이어 배틀 행동 선택

                switch (selBattle) {
                    case 1 -> battle(); // 적 처치
                    case 2 -> useSmoke();
                    case 3 -> useHeal();
                    case 4 -> useUlt();

                    default -> System.out.println("잘못된 입력입니다. 다시 선택하세요.\n");
                }
                battleEndCheck(); // 내가 죽거나 몬스터 처치 상태 체크
            }
            enemyDead(); // 적 처치
        } else if (event < 80) { // 20%
            getHeal(); // 회복 아이템 획득
        } else if (event < 95) { // 15%
            getSmoke(); // 연막 획득
        } else if (event < 100) { // 5%
            getUlt(); // 궁극기 획득
        }
    } // 탐색하기
    public void gameOverCheck() {
        if (playerHp <= 0) {
            System.out.println("- Game Over -");
            sc.close();
            isRunning = false; // 게임 종료
        }
    } // 게임 종료

    // 전투 메소드
    public int selectBattle() { // 전투행동 선택
        System.out.println("\n어떤 행동을 하시겠습니까?");
        System.out.println("1) 싸운다 2)  도망간다(연막소모)  3) 체력 회복(아이템소모)  4) 궁극기 사용(횟수차감)");
        selBattle = sc.nextInt();
        System.out.println("------------------");

        return selBattle;
    }
    public void spwnEnemy(){ // 적 생성
        isBattle = true; // 전투상태 변경

        // 랜덤능력치 적 생성
        enemyHp = ((int) (Math.random() * 21) + 30) * playerLevel; // 30~50 * 레벨 : 체력
        enemyAtk = ((int) (Math.random() * 10) + 1) * playerLevel; // 1~10  + 레벨 : 공격력
    }
    public void battleState() { // 전투상태
        System.out.println("\n몬스터 체력 : " + enemyHp);
        System.out.println("몬스터 공격력 : " + enemyAtk);
        System.out.println("체력 : " + playerHp + " / " + MAX_HP + " , 공격력 : " + playerAtk);
        System.out.println("보유 아이템 : 회복(x" + cntHeal + "), 연막(x" + cntSmoke + ")");
        System.out.println("궁극기 횟수 : " + cntUlt);
    }

    public void battle() {
        System.out.println("[몬스터와 싸웁니다.]");

        playerAtk(); // 플레이어 공격 처리
        if(enemyHp > 0){
            enemyAtk(); // 적 공격 처리
        }
    }
    public void playerAtk() {
        // 플레이어 공격
        int n = (int) (Math.random() * 2); // 플레이어 치명타 공격 0~1 랜덤 변수
        if (n == 0) { // 50% 일반 공격
            enemyHp -= playerAtk;
            System.out.println("몬스터에게 " + playerAtk + " 피해를 입혔습니다.");
        } else if (n == 1) { // 50% 치명타 공격
            enemyHp -= playerAtk * 2;
            System.out.println("몬스터에게 " + (playerAtk * 2) + " 치명타 피해를 입혔습니다.");
        }
    }
    public void enemyAtk() {
        // 몬스터 공격
        int m = (int) (Math.random() * 2); // 몬스터 치명타 공격 0~1 랜덤 변수
        if (m == 0) { // 50% 일반 피해
            playerHp -= enemyAtk;
            System.out.println(enemyAtk + " 피해를 받았습니다.");
        } else if (m == 1) { // 50% 치명타 피해
            playerHp -= enemyAtk * 2;
            System.out.println((enemyAtk * 2) + " 치명타 피해를 받았습니다.");
        }
    }

    public void useSmoke() {
        if (cntSmoke > 0) {
            System.out.println("[연막을 터트려 도망갑니다.]");

            int damage = (int) (Math.random() * 6); // 0~5
            playerHp -= damage;
            System.out.println("도망치면서 " + damage + "의 데미지를 받았습니다.");

            cntSmoke--;
            isBattle = false;
        } else {
            System.out.println("[아이템이 부족하여 도망칠 수 없습니다!]");
        }
    }
    public void useHeal() {
        if (cntHeal > 0) {
            System.out.println("[체력을 10 회복합니다.]");

            if (playerHp < MAX_HP) { // 체력 회복
                playerHp += 10;
                if (playerHp > MAX_HP) {
                    playerHp = MAX_HP;
                }
            }
            cntHeal--;
        } else {
            System.out.println("[아이템이 부족하여 회복할 수 없습니다!]");
        }
    }
    public void useUlt() {
        if (cntUlt > 0) {
            System.out.println("[궁극기를 사용합니다.]"); // 공격력 * 5

            int ultDamage = playerAtk * 5;
            enemyHp -= ultDamage; // 궁극기 공격(공격력 5배)

            cntUlt--; // 궁극기 사용 횟수 차감

            System.out.println("몬스터에게 " + ultDamage + " 궁극기 피해를 입혔습니다.");
        } else {
            System.out.println("[궁극기를 사용할 수 없습니다!]");
        }
    }

    public void battleEndCheck() {
        if (playerHp <= 0) {
            System.out.println("당신은 사망하였습니다.\n");
            isBattle = false;
        } else if (enemyHp <= 0) {
            System.out.println("\n몬스터를 처치하였습니다!\n");
            isBattle = false;
        }
    }
    public void enemyDead() {
        if (enemyHp <= 0) {
            levelCheck();
        }
    }
    public void levelCheck() {
        int exp = (int) (Math.random() * 50) + 50; // 50~100 랜덤 경험치
        playerExp += exp;
        if (playerExp >= MAX_EXP) {
            System.out.println("레벨이 상승하였습니다!");

            playerLevel++; // 레벨 상승
            playerExp = playerExp - MAX_EXP; // 초과한 경험치 적용
            playerAtk = playerLevel*10; // 레벨 * 10 : 공격력

            System.out.println("현재레벨 : " + playerLevel + "렙");
        }
    }

    // 아이템 획득 메소드
    public void getHeal() {
        System.out.println("회복 아이템을 획득하였습니다.");

        cntHeal += 1;
    }
    public void getSmoke() {
        System.out.println("연막을 획득하였습니다.");

        cntSmoke += 1;
    }
    public void getUlt() {
        System.out.println("궁극기 사용 횟수가 +1 증가하였습니다.");

        cntUlt += 1;
    }

    public void run() {
        startGame();

        while (isRunning) {
            selMenu = selectMenu(); // 메뉴 선택

            switch (selMenu) {
                case 1 -> showStatus(); // 상태창
                case 2 -> explore(); // 탐색하기
                case 0 -> exitGame(); // 게임 종료

                default -> System.out.println("잘못된 입력입니다. 다시 선택하세요.\n");
            }
            gameOverCheck();
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
