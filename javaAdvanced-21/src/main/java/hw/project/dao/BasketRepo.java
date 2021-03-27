package hw.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hw.project.domain.Basket;
import hw.project.domain.User;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Integer>{

	List<Basket> findAllByUser(User user);
}
