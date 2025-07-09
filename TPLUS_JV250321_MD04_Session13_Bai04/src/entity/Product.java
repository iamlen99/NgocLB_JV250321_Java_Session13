package entity;

import java.util.Scanner;

import static presentation.ProductManager.products;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void inputData (Scanner scanner) {
        this.id = inputProductId(scanner, "Enter Product ID");
        this.name = inputProductName(scanner, "Enter Product Name");
        this.price = inputProductPrice(scanner, "Enter Product Price");
    }

    public int inputProductId (Scanner scanner, String message) {
        System.out.println(message);
        do {
            try {
                int productId = Integer.parseInt(scanner.nextLine());
                if (products.containsKey(productId)) {
                    System.out.println("Id da ton tai vui long nhap lai:");
                } else {
                    return productId;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer: ");
            }

        } while (true);
    }

    public String inputProductName (Scanner scanner, String message) {
        System.out.println(message);
        do {
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a Product name: ");
            }
        } while (true);
    }

    public double inputProductPrice (Scanner scanner, String message) {
        System.out.println(message);
        do {
            try {
                double price = Double.parseDouble(scanner.nextLine());
                if(price > 0) {
                    return price;
                }
                System.out.println("Please enter a valid price (>0): ");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a double value: ");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Price: %.1f", this.id, this.name, this.price);
    }
}
