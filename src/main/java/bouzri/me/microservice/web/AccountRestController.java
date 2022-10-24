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
    public List<AccountResponseDTO> getAccounts()
    {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable() String id)
    {
        return accountService.getAccount(id);
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO accountSTO)
    {
        return accountService.AddAccount(accountSTO);
    }
    @PutMapping("/accounts/{id}")
    public AccountResponseDTO update(@RequestBody AccountRequestDTO accountRequestDTO, @PathVariable String id)
    {
        return accountService.update(accountRequestDTO, id);
    }

    @DeleteMapping("/accounts/{id}")
    public boolean delete(@PathVariable String id)
    {
        bar.deleteById(id);
        Account account = bar.findById(id).orElse(null);
        return account == null;
    }

}
