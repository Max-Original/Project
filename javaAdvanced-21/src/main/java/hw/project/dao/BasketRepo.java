package hw.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hw.project.domain.Basket;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Integer>{

}
