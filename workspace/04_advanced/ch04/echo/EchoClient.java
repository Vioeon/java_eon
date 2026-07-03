package ch04.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    void startClient() {
        try (
                // 서버에 접속 요청(localhost:50000)
//                Socket s = new Socket("localhost", 50000);
                Socket s = new Socket("dain2.iptime.org", 50000);
        ) {

            // 소켓이 닫히면 아래건 자동으로 닫힌다.
            // 키보드에서 줄 단위로 읽기 위한 Stream
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

            // Socket을 통해 데이터를 읽을 수 있는 InputStream 생성
            BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));

            // Socket을 통해 데이터를 전송할 수 있는 OutputStream 생성
//            BufferedWriter out =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            // println() 으로 데이터 전송해야함, BufferedWriter와 편의성 차이
//            PrintWriter out =new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            // new OutputStreamWriter 생략 가능
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String readData = "";

            // readLine : "\n" 전까지 읽는다. \n없으면 블로킹 상태됨
            while ((readData = key.readLine()) != null) {
//                out.write(readData + "\n"); // 서버로 내용 전송, readLine()으로 읽기 때문에 끝에 "\n" 써줘야함
                out.println(readData); // 자동으로 \n 붙여줌
                out.flush();
                String echoData = in.readLine(); // 서버의 데이터를 읽어옴
                System.out.println(echoData); // 내(client) 콘솔에 출력
            }
        } catch (IOException e) {
            System.out.println("네트워크 오류 발생: " + e.getMessage());
        }
    }

    void main() {
        startClient();
    }
}
