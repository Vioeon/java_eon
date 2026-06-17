package ch07;


import java.sql.*;

public class JdbcPostTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
        findAll();
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
        findById(10);
        update(10, "수정된 10번 게시글", "수정했어요");
        findAll();
        delete(1);
        findAll();
    }

    // 등록
    static void insert(int memberId, String title, String content) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate("INSERT INTO post(member_id, title, content) VALUES (" + memberId + ",'" + title + "','" + content + "');");

            System.out.println("게시글 등록 " + affectedRows + "건 완료\n");
        } catch (SQLException e) {
            System.out.println("에러 : " + e.getMessage());
        } finally {
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

    // 목록 조회
    static void findAll() {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, member_id, title, content, created_at FROM post;");
        ){
            while (rs.next()) {
                int id = rs.getInt("id");
                int memberId = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");

                System.out.println("id: " + id + ", memberId: " + memberId + ", title: " + title + ", content: " + content + ", createdAt: " + createdAt);
            }
            System.out.println();
        }catch(SQLException e){
            System.out.println("에러 : " + e.getMessage());
        }
    }

    // 한 건 조회
    static void findById(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT id, member_id, title, content, created_at FROM post WHERE id = " + id + ";");

            while (rs.next()) {
                int pid = rs.getInt("id");
                int memberId = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");

                System.out.println(id + "번 게시글 조회\nid: " + pid + ", memberId: " + memberId + ", title: " + title + ", content: " + content + ", createdAt: " + createdAt + "\n");
            }
        } catch (SQLException e) {
            System.out.println("에러 : " + e.getMessage());
        } finally {
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

    // 수정
    static void update(int id, String title, String content) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate("UPDATE post SET title = '" + title + "', content = '" + content + "' WHERE id = " + id + ";");

            System.out.println(id + "번 게시글 수정 " + affectedRows + "건 완료\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    // 삭제
    static void delete(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE id = " + id + ";");

            System.out.println(id + "번 게시글 삭제 " + affectedRows + "건 완료\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
