package bouzri.me.microservice.repositories;

import bouzri.me.microservice.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankAccountrepository extends JpaRepository<Account, String> {
}
