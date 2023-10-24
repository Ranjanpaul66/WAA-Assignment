package san.edu.lab12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import san.edu.lab12.domain.Product;
import san.edu.lab12.repository.ProductRepository;
import san.edu.lab12.service.ProductService;

@SpringBootApplication
public class Lab12Application implements ApplicationRunner {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab12Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Product product = new Product();
		product.setTitle("Pro 1");
		product.setPrice(2.34);
		product.setQuantity(12);

		productService.create(product);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						//.allowedOrigins("*");
				//.allowedOrigins("com.s3.us-east-1.amazonaws.com")
				.allowedOrigins("http://localhost:3000");
			}
		};
	}
}
