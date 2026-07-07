package ch04.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerMulti {
    void startServer() {
        try (
                ServerSocket ss = new ServerSocket(8080);
        ) {
            System.out.println("ServerSocket 생성 완료");

            while (true) {
                // 클라이언트의 서버 접속 대기
                Socket s = ss.accept(); // 블로킹 작업
                System.out.println("클라이언트 접속: " + s.getInetAddress().getHostName());

                WebServerTask worker = new WebServerTask(s);
                new Thread(worker).start();
            }

        } catch (IOException e) {
            System.out.println("네트워크 오류: " + e.getMessage());
        }
    }

    void main() {
        startServer();
    }
}
