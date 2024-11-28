package controller;

import Service.ProductCatalogService;
import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogService productCatalogService;

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category){
        return productCatalogService.addCategory(category.getName());
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productCatalogService.addProduct(product.getCategory().getId(),product.getName(),product.getDescription(),product.getPrice());

    }
}
