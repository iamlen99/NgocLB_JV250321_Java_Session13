import java.util.Arrays;
import java.util.List;

public class IntegerList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Cac so chan trong danh sach:");
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);

        System.out.println("Tong cac phan tu trong danh sach:");
        int sum;
        sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.println(sum);
    }
}
