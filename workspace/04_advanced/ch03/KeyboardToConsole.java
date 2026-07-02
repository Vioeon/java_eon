package ch03;

import java.io.IOException;

// 1. 표준입력장치(키보드) -> 표준출력장치(콘솔)
public class KeyboardToConsole {

    public static void main(String[] args) {
        try {
            // 표준 입력장치로 부터 1byte 읽어옴
            int readData = 0;

            while ((readData = System.in.read()) != -1) {
                // 표준 출력장치로 1byte 출력
                System.out.write(readData);
            }

        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
