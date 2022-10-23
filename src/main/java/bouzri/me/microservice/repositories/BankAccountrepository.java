package bouzri.me.microservice.repositories;

import bouzri.me.microservice.Entities.Account;
import bouzri.me.microservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountrepository extends JpaRepository<Account, String> {

    @RestResource(path = "/type")
    List<Account> findByType(@Param("t") AccountType type);
}
