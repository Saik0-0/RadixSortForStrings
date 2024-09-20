import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class radixSort {
    public static List<String> getSortedList(String fileName) throws IOException {
        List<String> file;

        try {
            file = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.out.println("С файлом какая-то проблема((");
            return null;
        }

        List<String> words = new ArrayList<>();
        StringBuilder currWord = new StringBuilder();

        for (int i = 0; i < String.valueOf(file).length(); i++) {
            char c = String.valueOf(file).charAt(i);

            if (Character.isLetter(c)) {
                currWord.append(Character.toLowerCase(c));
            }
            else {
                if (!currWord.isEmpty()) {
                    words.add(currWord.toString());
                    currWord.setLength(0);
                }
            }
        }

        if (!currWord.isEmpty()) {
            words.add(currWord.toString());
        }

        return digitalSort(words);
    }


    private static List<String> digitalSort(List<String> words) {


        //  ищем самое длинное слово
        int len = 0;
        for (String word: words) {
            if (word.length() > len) {
                len = word.length();
            }
        }
        
        //  более короткие слова дополним нулями слева
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() < len) {
                words.set(i, words.get(i) + "0".repeat(len - words.get(i).length()));
            }
        }

        //  поразрядная сортировка
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
                    forSort.get(0).add(word);
                }
            }

            words.clear();
            for (List<String> sorted: forSort) {
                words.addAll(sorted);
            }
        }

        //  удаляем добавленные нули
        words.replaceAll(word -> word.replaceAll("0+$", ""));

        return words.stream().distinct().toList();
    }
}
