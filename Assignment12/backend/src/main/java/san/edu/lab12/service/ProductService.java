package san.edu.lab12.service;

import san.edu.lab12.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product create(Product department);
    public Product update(Product department);
    public Product get(Long id);
    public Boolean delete(Long id);
    public List<Product> getAll();
}
