import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> f;
        try {
            f = radixSort.getSortedList("files/1.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(f);
    }
}