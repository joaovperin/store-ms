package br.jpe.storems.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jpe.storems.customers.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
