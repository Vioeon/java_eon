package ch04.echo.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMulti {
    void startServer() {
        try (
                ServerSocket ss = new ServerSocket(50000);
        ) {
            System.out.println("ServerSocket 생성 완료");

            while (true) {
                // 클라이언트의 서버 접속 대기
                Socket s = ss.accept(); // 블로킹 작업
                System.out.println("클라이언트 접속: " + s.getInetAddress().getHostName());

                EchoServerTask worker = new EchoServerTask(s);
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
