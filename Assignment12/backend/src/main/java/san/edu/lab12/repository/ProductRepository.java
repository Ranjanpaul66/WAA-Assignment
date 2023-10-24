package san.edu.lab12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import san.edu.lab12.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
