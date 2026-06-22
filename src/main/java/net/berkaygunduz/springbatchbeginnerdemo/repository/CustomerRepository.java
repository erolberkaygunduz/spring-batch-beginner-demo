package net.berkaygunduz.springbatchbeginnerdemo.repository;


import net.berkaygunduz.springbatchbeginnerdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
