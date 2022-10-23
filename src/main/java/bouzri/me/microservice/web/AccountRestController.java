package bouzri.me.microservice.web;

import bouzri.me.microservice.Entities.Account;
import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;
import bouzri.me.microservice.repositories.BankAccountrepository;
import bouzri.me.microservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountrepository bar;
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts()
    {
        return bar.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable() String id)
    {
        return bar.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s Not Found", id)));
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO accountSTO)
    {
        return accountService.AddAccount(accountSTO);
    }
    @PutMapping("/accounts/{id}")
    public Account update(@RequestBody Account account, @PathVariable String id)
    {
        Account acc = bar.findById(id).orElseThrow();
        if (account.getBalance() != null) acc.setBalance(account.getBalance());
        if (account.getCurrency() != null) acc.setCurrency(account.getCurrency());
        if (account.getCreated() != null) acc.setCreated(new Date());
        if (account.getType() != null) acc.setType(account.getType());
        return bar.save(acc);
    }

    @DeleteMapping("/accounts/{id}")
    public boolean delete(@PathVariable String id)
    {
        bar.deleteById(id);
        Account account = bar.findById(id).orElse(null);
        return account == null;
    }

}
