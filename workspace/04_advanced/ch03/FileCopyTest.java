package ch03;

import java.io.*;

// 2. 표준입력장치(키보드) -> 파일(output.txt)
public class FileCopyTest {

    void main(String[] args) {
        long start = System.currentTimeMillis();

//        copyFile("lib/mysql-connector-j-9.7.0.jar", "testmysql-connector-j-9.7.0.jar"); // 7849ms
//        copyFileUseBuffer("lib/mysql-connector-j-9.7.0.jar", "testmysql-connector-j-9.7.0.jar"); // 76ms
        copyFileCustomBuffer("lib/mysql-connector-j-9.7.0.jar", "testmysql-connector-j-9.7.0.jar"); // 3ms

        long end = System.currentTimeMillis();
        System.out.println("소요시간: " + (end - start) + "ms");
    }

    /**
     * 1차 스트림(FileInputStream, FileOutputStream)을 이용해서 파일을 복사
     *
     * @param org  원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFile(String org, String dest) {
        try (
                FileInputStream fis = new FileInputStream(org);
                FileOutputStream fos = new FileOutputStream(dest);
        ) {
            int readData = 0;

            while ((readData = fis.read()) != -1) {
                // 매번 파일에 접근하여 1byte씩 저장
                fos.write(readData);
            }
            // try-with-resources 문이므로 close()가 자동 호출
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 2차 스트림(BufferedInputStream, BufferedOutputStream)을 이용해서 파일을 복사
     * @param org
     * @param dest
     * 파일에서 버퍼 크기(기본 8192바이트)만큼 데이터를 읽어 입력 버퍼에 저장한다.
     * 입력 버퍼에서 데이터를 1바이트씩 읽어 처리 후 출력 버퍼에 1바이트씩 저장한다.
     * 출력 버퍼가 가득 차거나 flush(), close()가 호출되면 한 번에 파일에 저장한다.
     * 입력 버퍼의 데이터를 모두 사용하면 파일에서 다시 버퍼 크기만큼 읽어 같은 버퍼를 채우는 과정을 반복한다.
     */
    void copyFileUseBuffer(String org, String dest) {
        try (
                BufferedInputStream bi = new BufferedInputStream(new FileInputStream(org));
                BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(dest));

        ) {
            int readData = 0;

            // 버퍼 크기(기본:8192바이트)만큼 내용을 꺼내서 버퍼에 저장하고
            // read()로 버퍼에서 1byte씩 꺼내서 실행됨
            while ((readData = bi.read()) != -1) {
                // 버퍼에 1byte씩 저장
                bo.write(readData);
            }
            // try-with-resources 문이므로 close()가 자동 호출되어
            // 버퍼의 데이터가 flush(), close()로 한번에 저장 후 연결 종료
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     *
     * @param org
     * @param dest
     * 파일에서 8192바이트를 배열(buffer)에 읽고 8192바이트를 한 번에 파일에 기록 반복
     */
    void copyFileCustomBuffer(String org, String dest) {
        try (
                FileInputStream fis = new FileInputStream(org);
                FileOutputStream fos = new FileOutputStream(dest);
        ) {
            byte[] buffer = new byte[1024*8]; // 8kb 버퍼 생성
            int readSize = 0;

            //  파일에서 최대 buffer.length(8192바이트)만큼 데이터를 읽어
            // buffer 배열에 저장하고, 실제 읽은 바이트 수를 readSize에 반환한다.
            while ((readSize = fis.read(buffer)) != -1) {
                // 버퍼의 크기 8192byte씩 저장
                // buffer배열에서 0부터 파일에서 읽은 크기 만큼만 저장
                fos.write(buffer, 0, readSize);
            }
            // try-with-resources 문이므로 close()가 자동 호출되어
            // 버퍼의 데이터가 flush(), close()로 한번에 저장 후 연결 종료
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
