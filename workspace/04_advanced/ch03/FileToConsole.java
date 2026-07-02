package ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 3. 파일(output.txt) -> 표준출력장치(콘솔)
public class FileToConsole {

    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("output.txt");
        ) {
            int readData = 0;

            // 매번 파일에서 1byte씩 읽어 온다.
            while ((readData = fis.read()) != -1) {
                // 표준 출력장치로 1byte씩 출력
                System.out.write(readData);
            }

        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
