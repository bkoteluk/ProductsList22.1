package pl.bogdank.productslist.repository;

import org.springframework.stereotype.Repository;
import pl.bogdank.productslist.model.Product;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductsListRepository {

    List<Product> products = new LinkedList<>();

    public ProductsListRepository() {
//        products.add(new Product("Masło", 3));
//        products.add(new Product("Mleko", 3));
//        products.add(new Product("Jajka", 3));
//        products.add(new Product("Czekolada", 3));
//        products.add(new Product("Płatki", 3));
//        products.add(new Product("Mydło", 3));
    }

    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

}
