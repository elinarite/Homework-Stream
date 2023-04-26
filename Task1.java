package TaskWorkStream6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {

        // Найти все пары чисел из массива которые в сумме дает какое то заданное число стримами
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        int sum = 7;
        findSum(numbers, sum);

        //Дан массив стрингов. Вывести на экран все буквы и кол-во их повторений во всем массиве

        //Variant a
        String[] string = new String[]{"tata", "tota", "tita"};
        findDuplicateChars1(string);
        //Variant b
        findDuplicateChars2(string);
    }

    private static void findSum(Integer[] numbers, int sum) {
        Arrays.stream(numbers)
                .flatMap(i -> IntStream.range(i + 1, numbers.length)
                        .filter(j -> numbers[i] + numbers[j] == sum)
                        .mapToObj(j -> new int[]{numbers[i], numbers[j]}))
                .forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    private static String[] findDuplicateChars1(String[] string) {
        Arrays.stream(string)
                .map(x -> x.chars())
                .flatMap(x -> x.mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .forEach((Key, Value) -> System.out.println("char " + Key + " times " + Value));
        return string;
    }

    private static void findDuplicateChars2(String[] string) {
        Map<Character, Integer> map = new HashMap<>();
        Arrays.stream(string)
                .map(x -> x.chars())
                .flatMap(x -> x.mapToObj(c -> (char) c))
                .forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("char " + entry.getKey() + " time " + entry.getValue());

        }
    }
}