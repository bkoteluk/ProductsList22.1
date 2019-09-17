package pl.bogdank.productslist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bogdank.productslist.model.Product;
import pl.bogdank.productslist.repository.ProductsListRepository;

import java.util.List;

@Controller
public class ProductsListController {

    ProductsListRepository productsList;

    public ProductsListController(ProductsListRepository productsList) {
        this.productsList = productsList;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name,
                             @RequestParam Double price) {
        Product product = new Product(name, price);
        productsList.add(product);
        return "index";
    }

    @GetMapping({"/lista"})
    public String showProductsList(Model model) {
        List<Product> products = productsList.getAll();
        model.addAttribute("products", products);
        return "showlist";
    }

    @GetMapping({"/tabela"})
    public String showProductsTable(Model model) {
        List<Product> products = productsList.getAll();
        model.addAttribute("products", products);
        return "showtable";
    }
}
