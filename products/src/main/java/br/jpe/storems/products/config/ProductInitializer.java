package br.jpe.storems.products.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import br.jpe.storems.products.domain.Product;
import br.jpe.storems.products.repository.ProductRepository;

@Component
public class ProductInitializer implements ApplicationRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var list = List.of(Product.builder().description("potato").price(BigDecimal.ONE).build(),
				Product.builder().description("potato").price(BigDecimal.TEN).build());
		productRepository.saveAll(list);
	}

}
