package ch07;

import java.sql.*;

public class JdbcBasic {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
        selectAllMembers(); // 회원 조회
        insertMember("haru"+ (int)(Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "01022221111", 2); // 회원 등록
        updateMember(3, "3333", "3번 회원", "01033333333");
        deleteMember(2);
        selectAllMembers(); // 회원 목록 조회
    }

    // 회원 목록 조회
    public static void selectAllMembers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. 데이터베이스 연결 (Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성 (Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 생성)
            rs = stmt.executeQuery("SELECT * FROM member");

            while (rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("ID: " + id + ", email: " + email + ", name: " + name + ", phone: " + phone);
            }

        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 5. 생성된 리소스(객체)들을 생성의 역순으로 해제
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

    // 회원 등록
    public static void insertMember(String email, String password, String name, String phone, int recommenderId) {
        Connection conn = null;
        Statement stmt = null;
        // ResultSet rs = null; SELECT 문에서 사용

        try {
            // 1. 데이터베이스 연결 (Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성 (Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("INSERT INTO member (email, password, name, phone, recommender_id) VALUES \n" +
                    "    ('"+email+"', '"+password+"', '"+name+"', '"+phone+"', "+recommenderId+")");

            System.out.println("회원 등록 완료: " + affectedRows + "건 반영됨.");
        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
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

    // 회원 수정
    public static void updateMember(int id, String password, String name, String phone) {
        Connection conn = null;
        Statement stmt = null;
        // ResultSet rs = null; SELECT 문에서 사용

        try {
            // 1. 데이터베이스 연결 (Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성 (Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("UPDATE member SET password = '"+password+"', name = '"+name+"', phone = '"+phone+"' WHERE id = "+id+";");

            System.out.println("회원 수정 완료: " + affectedRows + "건 반영됨.");
        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
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

    // 회원 삭제
    public static void deleteMember(int id) {
        Connection conn = null;
        Statement stmt = null;
        // ResultSet rs = null; SELECT 문에서 사용

        try {
            // 1. 데이터베이스 연결 (Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성 (Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id ="+id+";");

            System.out.println("회원 탈퇴 완료: " + affectedRows + "건 반영됨.");
        } catch (SQLException e) {
            System.out.println("에러 발생 " + e.getMessage());
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
