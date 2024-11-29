import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static boolean isAscending(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }

        return IntStream.range(1, word.length())
                .allMatch(i -> word.charAt(i) >= word.charAt(i - 1));
    }

    public static String[] getAscendingWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new String[0];
        }

        return Arrays.stream(input.split("\\s+"))
                .filter(Main::isAscending)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your words: ");
        String input = scanner.nextLine();

        String[] ascendingWords = getAscendingWords(input);

        System.out.print("Array of ascending words: ");
        System.out.println(Arrays.stream(ascendingWords)
                .collect(Collectors.joining(", ", "[", "]")));
    }
}