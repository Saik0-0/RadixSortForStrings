import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(radixSort.getSortedList("files/1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> words = Arrays.asList("apple", "banana", "kiwi", "peach", "grape", "berry");
        radixSort.digitalSort(words);
    }
}
