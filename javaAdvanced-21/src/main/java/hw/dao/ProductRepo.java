package hw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hw.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
