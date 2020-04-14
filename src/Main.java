import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        productManager.addDemo();
        Main.showMenu();
        Main.controller();
    }

    public static void showMenu() {
        System.out.println("\nPRODUCT MANAGER");
        System.out.println("1.Add product");
        System.out.println("2.Edit product by ID");
        System.out.println("3.Delete product by ID");
        System.out.println("4.Show product list");
        System.out.println("5.Search product by name");
        System.out.println("6.Sort by ascending/descending price order");
        System.out.println("7.Write to file");
        System.out.println("8.Read default file");
        System.out.println("9.Exit");
        System.out.println("----------");
    }

    public static int scannerChoiceMenu() {
        System.out.print("Enter choice: ");
        int choiceMenu = scanner.nextInt();
        scanner.nextLine();
        while (choiceMenu < 1 || choiceMenu > 9) {
            System.out.print("Invalid choice! Enter again: ");
            choiceMenu = scanner.nextInt();
            scanner.nextLine();
        }
        return choiceMenu;
    }

    public static void sortByOrder() {
        System.out.println("1.Sort by Ascending price order");
        System.out.println("2.Sort by Descending price order");
        System.out.print("Enter choice: ");
        int choiceSort = scanner.nextInt();
        scanner.nextLine();
        switch (choiceSort) {
            case 1:
                productManager.sortAscendingOrder();
                break;
            case 2:
                productManager.sortDescendingOrder();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        productManager.showList();
    }

    public static void writeFileOption() {
        System.out.println("1. Write to default file");
        System.out.println("2. Write to new file");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                try {
                    productManager.writeToFile("producfile.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Enter new file path: ");
                try {
                    productManager.writeToFile(scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }



    public static void controller() {
        int choice = Main.scannerChoiceMenu();
        switch (choice) {
            case 1:
                System.out.println("1.Add product");
                Product product = productManager.inputProduct();
                productManager.add(product);
                Main.showMenu();
                Main.controller();
                break;
            case 2:
                System.out.println("2.Edit product by ID");
                productManager.editById(productManager.scannerID());
                Main.showMenu();
                Main.controller();
                break;
            case 3:
                System.out.println("3.Delete product by ID");
                productManager.deleteById(productManager.scannerID());
                Main.showMenu();
                Main.controller();
                break;
            case 4:
                System.out.println("4.Show pruduct list");
                productManager.showList();
                Main.showMenu();
                Main.controller();
                break;
            case 5:
                System.out.println("5.Search product by name");
                productManager.findByName(productManager.scannerName());
                Main.showMenu();
                Main.controller();
                break;
            case 6:
                System.out.println("6.Sort by ascending/descending price order");
                Main.sortByOrder();
                Main.showMenu();
                Main.controller();
                break;
            case 8:
                System.out.println("7.Read default product file");
                try {
                    productManager.readFile("producfile.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.showMenu();
                Main.controller();
                break;
            case 7:
                System.out.println("8.Read default product file");
                Main.writeFileOption();
                Main.showMenu();
                Main.controller();
            case 9:
                System.exit(0);
                break;
        }
    }
}
