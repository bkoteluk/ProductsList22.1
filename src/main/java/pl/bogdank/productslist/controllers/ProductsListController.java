package pl.bogdank.productslist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bogdank.productslist.model.Product;
import pl.bogdank.productslist.repository.ProductsRepository;

import java.util.List;

import static pl.bogdank.productslist.utils.ProductsChart.sum;

@Controller
public class ProductsListController {

    ProductsRepository productsList;

    public ProductsListController(ProductsRepository productsList) {
        this.productsList = productsList;
    }

    @GetMapping(value = {"/"})
    public String start() {
        return "/addproduct";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addProduct(@RequestParam String name,
                             @RequestParam Double price) {
        Product product = new Product(name, price);
        productsList.add(product);
        return "/addproduct";
    }

    @GetMapping({"/lista"})
    public String showProductsList(Model model) {
        List<Product> products = productsList.getAll();
        double number = sum(products);
        model.addAttribute("products", products);
        model.addAttribute("sum", number);
        return "showlist";
    }

    @GetMapping({"/tabela"})
    public String showProductsTable(Model model) {
        List<Product> products = productsList.getAll();
        double number = sum(products);
        model.addAttribute("products", products);
        model.addAttribute("sum", number);
        return "showtable";
    }
}
