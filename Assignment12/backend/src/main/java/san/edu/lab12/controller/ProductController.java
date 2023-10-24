package san.edu.lab12.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import san.edu.lab12.domain.Product;
import san.edu.lab12.service.ProductService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }
    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id")  Long id) {
        return productService.get(id);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }
}
