package bouzri.me.microservice.repositories;

import bouzri.me.microservice.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
