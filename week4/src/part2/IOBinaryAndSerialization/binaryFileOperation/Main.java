package part2.IOBinaryAndSerialization.binaryFileOperation;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void addProductToFile(String path, Product product) {
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<Product>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                products.add((Product) ois.readObject());
            }
            fis.close();
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public static Product findByIdFromFile(String path, int id) {
        Product product = null;
        List<Product> products = readDataFromFile(path);
        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
            }
        }
        return product;
    }

    public static void main(String[] args) {
        String path = "src\\part2\\IOBinaryAndSerialization\\binaryFileOperation\\products.bin";
        addProductToFile(path, new Product(1, "car1", 100, "Volvo", "A car"));
        addProductToFile(path, new Product(2, "car2", 200, "Mercedes", "A car"));
        addProductToFile(path, new Product(3, "car3", 300, "Honda", "A car"));
        addProductToFile(path, new Product(4, "car4", 400, "Random Guy", "A car"));
        addProductToFile(path, new Product(5, "car5", 500, "Iran", "A car"));

        List<Product> products = readDataFromFile(path);
        for (Product product : products) {
            System.out.println(product);
        }

        addProductToFile(path, new Product(6, "car5", 500, "Iran", "A car"));
        products = readDataFromFile(path);
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println(findByIdFromFile(path, 1));
        System.out.println(findByIdFromFile(path, 6));
    }
}
