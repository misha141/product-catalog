package Service;

import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryRepository;
import repository.ProductRepository;

public class ProductCatalogService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Category addCategory(String name){
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public Product addProduct(Long categoryId, String name, String description, double price){
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(category == null){
            throw new IllegalArgumentException("Category not found");
        }

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);

        product.setPrice(price);
        product.setCategory(category);
        return productRepository.save(product);
    }
}
