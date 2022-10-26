package bouzri.me.microservice.web;

import bouzri.me.microservice.Entities.Account;
import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;
import bouzri.me.microservice.repositories.BankAccountrepository;
import bouzri.me.microservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
// 3rd part : 43 : 00
public class AccountGraphqlController {
    private BankAccountrepository bar;
    private AccountService as;


    @QueryMapping
    public List<Account> accountsList()
    {
        return bar.findAll();
    }

    @QueryMapping
    public Account accountsById(@Argument String id)
    {
        return bar.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account \' %s \' not Found", id)));
    }
    @MutationMapping
    public AccountResponseDTO addAccount(@Argument AccountRequestDTO account)
    {
        return as.AddAccount(account);
    }
}
