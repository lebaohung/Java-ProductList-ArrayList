import java.io.*;
import java.util.*;

public class ProductManager {
    private LinkedList<Product> productList = new LinkedList<Product>();
//  private ArrayList<Product> productList = new ArrayList<Product>();
    private Scanner scanner = new Scanner(System.in);

    public void addDemo() {
        productList.add(new Product(1, "IPhone6", 5000000));
        productList.add(new Product(2, "IPhone 7", 5500000));
        productList.add(new Product(3, "IPhone X", 10000000));
        productList.add(new Product(4, "IPhone 11 Pro", 25000000));
        productList.add(new Product(5, "IPhone 8", 9000000));
        productList.add(new Product(6, "IPhone 8 Plus", 11000000));
    }
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
        System.out.printf("%-5s%-20s%15s\n", "ID", "Name", "Price");
        for (int i = 0; i < productList.size(); i++) {
            Product thisProduct = productList.get(i);
            System.out.printf("%-5d%-20s%15d\n", thisProduct.getId(), thisProduct.getName(), thisProduct.getPrice());
        }
    }

    public void findByName(String name) {
        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            Product thisProduct = productList.get(i);
            if (thisProduct.getName().toLowerCase().contains(name)) {
                if (!check) {
                    System.out.printf("%-5s%-20s%15s\n", "ID", "Name", "Price");
                }
                System.out.printf("%-5d%-20s%15d\n", thisProduct.getId(), thisProduct.getName(), thisProduct.getPrice());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Invalid Product name!");
        }
    }

    public void sortAscendingOrder() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    public void sortDescendingOrder() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
    }

    public void writeToFile(String path) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Product product : productList) {
                objectOutputStream.writeObject(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public void readFile(String path) throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Product product = null;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }
    }

}
