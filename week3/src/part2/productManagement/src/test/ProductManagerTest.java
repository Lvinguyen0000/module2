package part2.productManagement.src.test;

import part2.productManagement.src.PriceComparator;
import part2.productManagement.src.Product;
import part2.productManagement.src.ProductManager;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class ProductManagerTest {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product(ProductManager.currentId, "pencil", "a pencil", 10.0));
        manager.addProduct(new Product(ProductManager.currentId, "pen", "a pen", 15.0));
        manager.addProduct(new Product(ProductManager.currentId, "notebook", "a notebook", 20.0));
        manager.addProduct(new Product(ProductManager.currentId, "eraser", "an eraser", 5.0));
        manager.addProduct(new Product(ProductManager.currentId, "ruler", "a ruler", 8.0));
        manager.addProduct(new Product(ProductManager.currentId, "marker", "a marker", 12.0));
        manager.addProduct(new Product(ProductManager.currentId, "highlighter", "a highlighter", 18.0));
        manager.addProduct(new Product(ProductManager.currentId, "calculator", "a calculator", 30.0));
        manager.addProduct(new Product(ProductManager.currentId, "backpack", "a backpack", 50.0));
        manager.addProduct(new Product(ProductManager.currentId, "book", "a book", 25.0));

        System.out.println(manager);

        manager.ascendingSort();
        System.out.println(manager);

        manager.descendingSort();
        System.out.println(manager);
    }
}