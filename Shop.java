import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    HashMap<Integer, Product> products = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    String option;
    Product product;
    public void optionsMenu() {
        do {
            System.out.println("Enter 'L' to load previous transactions");
            System.out.println("Enter 'C' to create a transaction");
            System.out.println("Enter 'R' to read your transactions");
            System.out.println("Enter 'U' to update a transaction");
            System.out.println("Enter 'D' to delete a transaction");
            System.out.println("Enter 'Q' to quit");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("L")){
                product.load();
            } else if (choice.equalsIgnoreCase("C")) {
                    System.out.println("Enter the id of your product: ");
                    int id = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter the type of product ");
                    String productType = scan.nextLine();
                    System.out.println("Enter the price of your product: ");
                    double price = Double.parseDouble(scan.nextLine());

                    product = new Product(productType, price, id);
                    products.put(id, product);
                    System.out.println(products);

            } else if (choice.equalsIgnoreCase("R")) {
                System.out.println(products);

            } else if (choice.equalsIgnoreCase("U")) {
                System.out.println("Enter the id of the product you would like to update: ");
                int id = Integer.parseInt(scan.nextLine());
                Product productToUpdate;

                System.out.println("Enter the type of product: ");
                String newProductType = scan.nextLine();
                System.out.println("Enter the price of the product: ");
                double newPrice = Double.parseDouble(scan.nextLine());
                productToUpdate = new Product(newProductType, newPrice, id);

//                products.remove(id);
                products.put(id, productToUpdate);
                System.out.println(products);
            } else if (choice.equalsIgnoreCase("D")) {
                System.out.println("Enter the id of the product you would like to delete: ");
                int idToRemove = Integer.parseInt(scan.nextLine());
                products.remove(idToRemove);
                System.out.println(products);
            } else if (choice.equalsIgnoreCase("Q")) {
                System.out.println("Would you like to save your transactions? Type 'yes' or 'no'");
                String save = scan.nextLine();
                if (save.equalsIgnoreCase("yes")){
                    product.save();
                }
                break;
            }else
                System.out.println("Invalid input, please select an option from the menu.");

        }while (true);
        }
    }

