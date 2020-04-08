import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    private LinkedList<Product> productList = new LinkedList<Product>();
//  private ArrayList<Product> productList = new ArrayList<Product>();
    private static Scanner scanner = new Scanner(System.in);

    public Product inputProduct() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(id, name, price);
        return product;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public int scannerID() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public String scannerName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        return name;
    }

    public void editById(int id) {
        boolean checkId = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                System.out.println("ID: " + id);
                System.out.print("Edit name: ");
                productList.get(i).setName(scanner.nextLine());
                System.out.print("Edit price: ");
                productList.get(i).setPrice(scanner.nextInt());
                scanner.nextLine();
                checkId = true;
            }
        }
        if (!checkId) System.out.println("Invalid ID!");
    }

    public void deleteById(int id) {
        boolean checkID = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                System.out.print("Deleting ID Product: " + id + "...");
                productList.remove(i);
                System.out.println("Done!");
                checkID = true;
            }
        }
        if (!checkID) System.out.println("Invalid ID!");
    }

    public void showList() {
        System.out.printf("%-5s%-20s%-15s\n", "ID", "Name", "Price");
        for (int i = 0; i < productList.size(); i++) {
            Product thisProduct = productList.get(i);
            System.out.printf("%-5d%-20s%-15d\n", thisProduct.getId(), thisProduct.getName(), thisProduct.getPrice());
        }
    }

    public void findByName(String name) {
        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            Product thisProduct = productList.get(i);
            if (thisProduct.getName().equals(name)) {
                if (check) {
                    System.out.printf("%-5s%-20s%-15s\n", "ID", "Name", "Price");
                }
                System.out.printf("%-5d%-20s%-15d\n", thisProduct.getId(), thisProduct.getName(), thisProduct.getPrice());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Invalid Product name!");
        }
    }

    public void sortAscendingOrder() {
        for (int i = 0; i < productList.size() -1 ; i++) {
            Product currentProduct = productList.get(i);
            for (int j = i +1; j < productList.size(); j++) {
                Product toCompareProduct = productList.get(j);
                if (currentProduct.getPrice() > toCompareProduct.getPrice()) {
                    Product temp = productList.get(i);
                    productList.set(i, productList.get(j));
                    productList.set(j, temp);
                    currentProduct = productList.get(i);
                }
            }
        }
    }

    public void sortDescendingOrder() {
        for (int i = 0; i < productList.size() -1; i++) {
            Product currentProduct = productList.get(i);
            for (int j = i +1; j < productList.size(); j++) {
                Product toCompareProduct = productList.get(j);
                if (currentProduct.getPrice() < toCompareProduct.getPrice()) {
                    Product temp = productList.get(i);
                    productList.set(i, productList.get(j));
                    productList.set(j, temp);
                    currentProduct = productList.get(i);
                }
            }
        }
    }

}
