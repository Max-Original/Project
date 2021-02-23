package hw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import hw.domain.Basket;

public interface BasketRepo extends JpaRepository<Basket, Integer>{

}
