package ch07;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

import static ch07.JdbcMemberTest.login;

public class ConnectionPoolTest {

    private static DataSource dataSource;

    // static 블럭은 실행될 때 최초 1번만 실행 된다.
    static{
        HikariConfig config = new HikariConfig("/hikari.properties");
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) {
//        findAll();
//        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
//        findById(10);
//        update(10, "수정된 10번 게시글", "수정했어요");
//        findAll();
//        delete(1);
//        findAll();
//
//        deleteAll(2);
//        findAll();

        login("haru@gmail.com", "123");
        login("haru@gmail.com", "pwd123");
        login("haru@gmail.com' OR '1' = '1", "asdfas");

        if(dataSource != null){
            ((HikariDataSource)dataSource).close();
        }
    }

    // 등록
    static void insert(int memberId, String title, String content) {
        String sql = "INSERT INTO post(member_id, title, content) VALUES (?, ?, ?);";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, memberId);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int affectedRows = pstmt.executeUpdate();

            //System.out.println("게시글 등록 " + affectedRows + "건 완료");
        } catch (SQLException e) {
            System.out.println("에러 : " + e.getMessage());
        } finally {
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

    // 게시글 전체 목록 조회
    static void findAll() {
        findAll("");
    }

    // 게시글 검색 목록 조회
    static void findAll(String keyword) {
        String sql = "SELECT id, member_id, title, content, created_at FROM post";

        boolean hasKeyword = keyword != null && !keyword.equals("");
        if (hasKeyword) {
            sql += " WHERE title LIKE ? OR content LIKE ?";
        }

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            if (hasKeyword) {
                String searchKeyword = "%" + keyword + "%";
                pstmt.setString(1, searchKeyword);
                pstmt.setString(2, searchKeyword);
            }
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int memberId = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createdAt = rs.getString("created_at");

                System.out.println("id: " + id + ", memberId: " + memberId + ", title: " + title + ", content: " + content + ", createdAt: " + createdAt);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("에러 : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 한 건 조회
    static void findById(int id) {
        String sql = "SELECT id, member_id, title, content, created_at FROM post WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
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

    // 수정
    static void update(int id, String title, String content) {
        String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();

            System.out.println(id + "번 게시글 수정 " + affectedRows + "건 완료\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    // 게시글 1개 삭제
    static void delete(int id) {
        String sql = "DELETE FROM post WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            System.out.println(id + "번 게시글 삭제 " + affectedRows + "건 완료\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    // 회원의 모든 게시글 삭제
    static void deleteAll(int memberId) {
        String sql = "DELETE FROM post WHERE member_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, memberId);
            int affectedRows = pstmt.executeUpdate();

            System.out.println(memberId + "번 회원의 모든 게시글 삭제 " + affectedRows + "건 완료\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
}
