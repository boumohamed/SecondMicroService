package bouzri.me.microservice.repositories;

import bouzri.me.microservice.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountrepository extends JpaRepository<Account, String> {
}
