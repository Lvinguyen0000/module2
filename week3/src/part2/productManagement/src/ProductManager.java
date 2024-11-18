package part2.productManagement.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<Product>();
    public static int currentId = 1000;

    public ProductManager() {}

    public void addProduct(Product product) {
        if (products.contains(product)) return;
        products.add(product);
        currentId++;
    }

    public boolean removeById(int id){
        for (Product p: products){
            if (p.getId() == id){
                products.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean editById(int id, String name, String description, double price){
        for (Product p: products){
            if (p.getId() == id){
                if (!name.isEmpty()) p.setName(name);
                if (!description.isEmpty()) p.setDescription(description);
                if (price != 0) p.setPrice(price);
                return true;
            }
        }
        return false;
    }

    public Product findByName(String name){
        for (Product p: products){
            if (Objects.equals(p.getName(), name)){
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Product p: products){
            res.append(p.toString()).append("\n");
        }
        return res.toString();
    }

    public void ascendingSort(){
        PriceComparator priceComparator = new PriceComparator();
        products.sort(priceComparator);
    }

    public void descendingSort(){
        PriceComparator priceComparator = new PriceComparator();
        ascendingSort();
        Collections.reverse(products);
    }
}
