package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventPractice {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventPractice(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EventPractice() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void inputData(Scanner scanner) {
        this.name = inputEventName(scanner);
        if (this.name.equalsIgnoreCase("exit")) {
            return;
        }
        this.startDate = inputStartDate(scanner);
        this.endDate = inputEndDate(scanner);
    }

    public String inputEventName (Scanner scanner) {
        do {
            System.out.println("Nhap ten su kien (hoac 'exit' de thoat)");
            String eventName = scanner.nextLine();
            if (isNotEmpty(eventName)) {
                return eventName;
            } else {
                System.out.println("Can not enter empty string");
            }
        } while (true);
    }

    public LocalDateTime inputStartDate (Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        do {
            System.out.println("Nhap thoi gian bat dau (dd-MM-yyyy HH:mm)");
            try {
                LocalDateTime startDate = LocalDateTime.parse(scanner.nextLine(), formatter);
                return startDate;
            } catch (Exception e) {
                System.out.println("Enter not valid date");
            }
        } while (true);
    }

    public LocalDateTime inputEndDate (Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        do {
            System.out.println("Nhap thoi gian ket thuc (dd-MM-yyyy HH:mm)");
            try {
                LocalDateTime endDate = LocalDateTime.parse(scanner.nextLine(), formatter);
                return endDate;
            } catch (Exception e) {
                System.out.println("Enter not valid date");
            }
        } while (true);
    }

    public boolean isNotEmpty (String data) {
        return data != null && !data.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
