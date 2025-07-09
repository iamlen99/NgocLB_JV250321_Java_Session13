import presentation.ProductManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productManager.addProduct(scanner);
                    break;

                case 2:
                    productManager.editProduct(scanner);
                    break;

                case 3:
                    productManager.deleteProduct(scanner);
                    break;

                case 4:
                    productManager.displayProducts();
                    break;

                case 5:
                    productManager.filterProductsByPrice();
                    break;

                case 6:
                    productManager.calculateSumPriceAllProducts();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter a valid choice from 0-6");
            }
        } while (true);
    }
}
