package ch01;

import java.sql.*;

public class JdbcMemberTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
        selectAllMembers(); // 회원 조회

        try { // insertMember에서 Exception처리의 주체를 상위 메소드로 전가하여 여기서 try-catch로 처리
            insertMember("haru" + (int) (Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "01022221111", 1); // 회원 등록
        }catch (IllegalAccessError e){
            System.out.println(e.getMessage());
            insertMember("haru" + (int) (Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "010-2222-1111".replace("-", ""), 1); // 회원 등록
        }

        updateMember(3, "3333", "3번 회원", "01033333333");
        deleteMember(2);
        selectAllMembers(); // 회원 목록 조회

        login("haru@gmail.com", "pwd123");
//        login("haru@gmail.com", "pwd123");
//        login("haru@gmail.com' OR '1' = '1", "asdfas");
    }

    public static void login(String email, String password) {
        if(email == null || email.isBlank() || password == null || password.isBlank()){
            throw new LoginFailException("email과 password를 확인하세요.");
        }

        String sql = "SELECT * FROM MEMBER WHERE email = ? AND password = ?";
        System.out.println("로그인");

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String email2 = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("로그인에 성공했습니다.");
                System.out.println("ID: " + id + ", email: " + email2 + ", name: " + name + ", phone: " + phone);
            } else {
                System.out.println("아이디와 패스워드를 확인하세요.");
            }

        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 목록 조회
    public static void selectAllMembers() {
        String sql = "SELECT * FROM member";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("ID: " + id + ", email: " + email + ", name: " + name + ", phone: " + phone);
            }

        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 등록
    public static void insertMember(String email, String password, String name, String phone
            , int recommenderId) throws IllegalAccessError {

        String sql = "INSERT INTO member (email, password, name, phone, recommender_id) VALUES (?, ?, ?, ?, ?)";
        // ResultSet rs = null; SELECT 문에서 사용
        if(phone.length() > 11){
            // 에러를 만들어 발생시킨다.
            throw new IllegalAccessError("phone은 12자 이내여야 합니다.");
        }

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, phone);
            pstmt.setInt(5, recommenderId);
            int affectedRows = pstmt.executeUpdate();

            System.out.println("회원 등록 완료: " + affectedRows + "건 반영됨.");
        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 수정
    public static void updateMember(int id, String password, String name, String phone) {
        String sql = "UPDATE member SET password = ?, name = ?, phone = ? WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, password);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setInt(4, id);
            int affectedRows = pstmt.executeUpdate();

            System.out.println("회원 수정 완료: " + affectedRows + "건 반영됨.");
        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 회원 삭제
    public static void deleteMember(int id) {
        Connection conn = null;
        Statement stmt = null;
        // ResultSet rs = null; SELECT 문에서 사용

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            // 트랜잭션 제어를 위해 자동 커밋 중지
            conn.setAutoCommit(false);

            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE id =" + id + ";");
            System.out.println("회원의 모든 게시글 삭제 완료: " + affectedRows + "건 완료");

            affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id =" + id + ";");
            System.out.println("회원 탈퇴 완료: " + affectedRows + "건 반영됨.");

            // 성공
            conn.commit();
        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e2) {
            }
            e.printStackTrace();
        } finally {
            // 5. 생성된 리소스(객체)들을 생성의 역순으로 해제
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
