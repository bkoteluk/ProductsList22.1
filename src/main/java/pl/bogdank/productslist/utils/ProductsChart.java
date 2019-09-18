package pl.bogdank.productslist.utils;

import pl.bogdank.productslist.model.Product;

import java.util.List;

public class ProductsChart {

    public static double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}
