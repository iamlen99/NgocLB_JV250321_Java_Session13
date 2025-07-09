import entity.EventPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<EventPractice> eventPractices = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            EventPractice eventPractice = new EventPractice();
            eventPractice.inputData(scanner);
            if (eventPractice.getName().equals("exit")) {
                break;
            }
            eventPractices.add(eventPractice);

        } while (true);

        System.out.println("Danh sach su kien:");
        eventPractices.forEach(System.out::println);
    }
}
