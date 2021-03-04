package hw.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hw.project.domain.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
