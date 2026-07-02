package ch03;

import java.io.FileOutputStream;
import java.io.IOException;

// 2. 표준입력장치(키보드) -> 파일(output.txt)
public class KeyboardToFile {

    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("output.txt");

        ) {
            // 표준 입력장치로 부터 1byte 읽어옴
            int readData = 0;

            // 표준 입력 장치로 부터 1byte 읽어온다.
            while ((readData = System.in.read()) != -1) {
                // 파일에 1byte씩 저장
                fos.write(readData);
            }

        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
