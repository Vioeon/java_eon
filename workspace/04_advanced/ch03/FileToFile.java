package ch03;

import java.io.*;

// 4. 파일(output.txt) -> 파일(output-copy.txt)
public class FileToFile {

    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("output.txt");
                FileOutputStream fos = new FileOutputStream("output-copy.txt");
        ) {
            int readData = 0;

            // 버퍼 크기(기본:8192바이트)만큼 내용을 꺼내서 버퍼에 저장하고
            // read()로 버퍼에서 1byte씩 꺼내서 실행됨
            while ((readData = fis.read()) != -1) {
                // 버퍼에 1byte씩 저장
                fos.write(readData);
            }
            // try-with-resources 문이므로 close()가 자동 호출되어
            // 버퍼의 데이터가 flush(), close()로 한번에 저장 후 연결 종료
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
