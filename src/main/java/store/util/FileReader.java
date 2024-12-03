package store.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String readFileToString(String filePath) {
        try {
            // 파일의 모든 내용을 문자열로 읽어들임
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            // 예외 처리
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}
