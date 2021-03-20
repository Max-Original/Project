package hw.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hw.project.domain.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
