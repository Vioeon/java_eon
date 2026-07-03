package ch04.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트로부터 수신된 메세지를 그대로 반송
// 네트워크 프로그램 개발 시 가장 먼저 만들어서 클라이언트와 서버간 통신 상태 확인하는데 사용
public class EchoServer {
    void startServer() {
        try (
                ServerSocket ss = new ServerSocket(50000);

        ) {
            System.out.println("ServerSocket 생성 완료");

            // 클라이언트의 서버 접속 대기
            Socket s = ss.accept(); // 블로킹 작업
            System.out.println("클라이언트 접속: " + s.getInetAddress().getHostName());

            // 클라이언트의 메세지를 수신하는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // 클라이언트에 메세지를 송신하는 OutputStream 생성
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            // println으로 데이터 전송
//            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            // new OutputStreamWriter
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String readData = "";

            // readLine : "\n"기준으로 끊어서 읽는다. \n없으면 블로킹 상태됨
            while ((readData = in.readLine()) != null) {
                System.out.println("client 입력: " + readData);
//                out.write("서버의 응답: " + readData + "\n"); // 버퍼에 저장, readLine()으로 읽기 때문에 끝에 "\n" 써줘야함
                out.println("서버의 응답: " + readData); // 자동으로 \n 붙여줌
                out.flush(); // 버퍼의 모든 내용을 전송 후 버퍼 비운다.
                System.out.println(readData); // 클라이언트의 메세지를 서버에도 출력
            }
        } catch (IOException e) {
            System.out.println("네트워크 오류: " + e.getMessage());
        }
    }

    void main() {
        startServer();
    }
}
