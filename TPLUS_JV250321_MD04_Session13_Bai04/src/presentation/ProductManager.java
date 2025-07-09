package presentation;

import entity.Product;

import java.util.*;


public class ProductManager {
    public static Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Scanner scanner) {
        Product newProduct = new Product();
        newProduct.inputData(scanner);
        products.put(newProduct.getId(), newProduct);
        System.out.println("Product added successfully.");
    }

    public void editProduct(Scanner scanner) {
        System.out.print("Enter Product ID to edit: ");
        int editId = Integer.parseInt(scanner.nextLine());

        int editIndex = findIndexById(editId);
        if (editIndex == -1) {
            System.err.println("Invalid product ID");
        } else {
            System.out.println("Enter new Product Name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new Product Price: ");
            double newPrice = Double.parseDouble(scanner.nextLine());
            Product product = new Product(editId, newName, newPrice);
            products.put(editId, product);
            System.out.println("Product updated successfully.");
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.println("Enter Product ID to delete: ");
        int deleteId = Integer.parseInt(scanner.nextLine());

        int deleteIndex = findIndexById(deleteId);
        if (deleteIndex == -1) {
            System.err.println("Product not found.");
        } else {
            products.remove(deleteId);
            System.out.println("Product deleted successfully.");
        }
    }

    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void filterProductsByPrice() {
        products.entrySet().stream().filter(product -> product.getValue().getPrice() > 100)
                .forEach(product -> System.out.println(product.getValue()));
    }

    public void calculateSumPriceAllProducts() {
        double sum = 0;
        sum = products.entrySet().stream()
                .mapToDouble(product -> product.getValue().getPrice()).sum();
        System.out.println("Total value of products " + sum);
    }

    public int findIndexById(int id) {
        for(Map.Entry<Integer, Product> entry : products.entrySet()) {
            if(entry.getKey() == id) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
