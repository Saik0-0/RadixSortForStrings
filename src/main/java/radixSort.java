import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class radixSort {
    public static String getSortedList(String fileName) throws IOException {
        List<String> file;
        try {
            file = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.out.println("С файлом какая-то проблема((");
            return null;
        }
        return String.valueOf(file);
    }

    public static void digitalSort(List<String> words) {
        char[] chars = new char[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + i);
        }


    }
}
