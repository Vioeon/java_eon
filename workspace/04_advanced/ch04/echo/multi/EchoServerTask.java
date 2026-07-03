package ch04.echo.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerTask implements Runnable {
    private final Socket s;

    EchoServerTask(Socket s) {
        this.s = s;
    }

    public void run() {
        try (
                Socket clientSocket = this.s;
        ) {
            // 클라이언트의 메세지를 수신하는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // new OutputStreamWriter 생략 가능
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String readData = "";

            // readLine : "\n"기준으로 끊어서 읽는다. \n없으면 블로킹 상태됨
            while ((readData = in.readLine()) != null) {
                System.out.println("client 입력: " + readData); //클라이언트의 메세지를 서버에도 출력
                out.println("서버의 응답: " + readData); // 자동으로 \n 붙여줌
                out.flush(); // 버퍼의 모든 내용을 전송 후 버퍼 비운다.
            }
        } catch (IOException e) {
            System.out.println("네트워크 예외 발생 : " + e.getMessage());
        }
    }
}
