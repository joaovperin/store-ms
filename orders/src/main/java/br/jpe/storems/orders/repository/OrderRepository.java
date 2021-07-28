package br.jpe.storems.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jpe.storems.orders.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
