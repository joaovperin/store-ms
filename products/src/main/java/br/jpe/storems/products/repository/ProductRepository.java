package br.jpe.storems.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jpe.storems.products.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
