package TaskWorkStream6;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2_StringStream {

    /**
     * String text = "???";
     * И вывести на экран все уникальные слова и количество их повторений
     * отсортировать в порядке убывания.
     * Так же подсчитать количество всех слов
     * Ex:
     * mama - 2
     * is - 3
     * i - 3
     * throw - 1
     */
    public static void main(String[] args) {
        String text = "Throw mama i is, is i mama, is i.";
        countWords(text);
    }

    private static void countWords(String text) {
        String[] strings = text.replaceAll("[.,]", "").split(" ");
        Long totalWords = Arrays.stream(strings)
                .count();
        Arrays.stream(strings)
                //   .sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        System.out.printf("Total words %d in text",totalWords);
    }
}