import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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

        //  ищем самое длинное слово
        int len = 0;
        for (String word: words) {
            if (word.length() > len) {
                len = word.length();
            }
        }
        
        //  более короткие слова дополним нулями слева
        for (int i = 0; i < words.toArray().length; i++) {
            if (words.get(i).length() < len) {
                words.set(i, words.get(i) + "0".repeat(len - words.get(i).length()));
            }
        }

        for (int i = len - 1; i >= 0; i--) {

            List<List<String>> forSort = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                forSort.add(new ArrayList<>());
            }

            for (String word: words) {
                if (word.charAt(i) != '0') {
                    forSort.get(word.charAt(i) - 'a').add(word);
                }
                else {
                    forSort.get('z' - 'a').add(word);
                }
            }

            words.clear();
            for (List<String> sorted: forSort) {
                words.addAll(sorted);
            }
        }

        System.out.println(words);
    }
}
