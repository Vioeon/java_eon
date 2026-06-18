package ch07;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

public class JdbcMemberTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
//        selectAllMembers(); // 회원 조회
//        insertMember("haru"+ (int)(Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "01022221111", 2); // 회원 등록
//        updateMember(3, "3333", "3번 회원", "01033333333");
//        deleteMember(2);
//        selectAllMembers(); // 회원 목록 조회

//        login("haru@gmail.com", "123");
//        login("haru@gmail.com", "pwd123");
//        login("haru@gmail.com' OR '1' = '1", "asdfas");

        deleteMember(5);
    }

    public static void login(String email, String password) {
        String sql = "SELECT * FROM MEMBER WHERE email = ? AND password = ?";
        System.out.println("로그인 쿼리: " + sql);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. 데이터베이스 연결 (Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행 객체 생성 (Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 생성)
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

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
        } finally {
            // 5. 생성된 리소스(객체)들을 생성의 역순으로 해제
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
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
                    "    ('" + email + "', '" + password + "', '" + name + "', '" + phone + "', " + recommenderId + ")");

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
            int affectedRows = stmt.executeUpdate("UPDATE member SET password = '" + password + "', name = '" + name + "', phone = '" + phone + "' WHERE id = " + id + ";");

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

            // 트랜잭션 제어를 위해 자동 커밋 중지
            conn.setAutoCommit(false);

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE id =" + id + ";");
            System.out.println("회원의 모든 게시글 삭제 완료: " + affectedRows + "건 완료");

            // 10초 동안 휴식
            Thread.sleep(1000 * 10);

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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
