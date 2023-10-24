package san.edu.lab12.service;

import org.springframework.stereotype.Service;
import san.edu.lab12.domain.Product;
import san.edu.lab12.repository.ProductRepository;

import java.util.List;


@Service
public class ProductImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductImpl(ProductRepository departmentRepository) {
        this.productRepository = departmentRepository;
    }

    @Override
    public Product create(Product department) {
        return productRepository.save(department);
    }

    @Override
    public Product update(Product department) {
        return productRepository.save(department);
    }

    public Product get(Long id) {
        return productRepository.findById(id).get();
    }
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }
    @Override
    public Boolean delete(Long id) {
        productRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
