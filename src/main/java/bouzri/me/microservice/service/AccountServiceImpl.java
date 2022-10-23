package bouzri.me.microservice.service;

import bouzri.me.microservice.Entities.Account;
import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;
import bouzri.me.microservice.repositories.BankAccountrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private BankAccountrepository bar;
    @Override
    public AccountResponseDTO AddAccount(AccountRequestDTO accountDTO) {
        Account account = Account.builder()
                .id(UUID.randomUUID().toString())
                .created(new Date())
                .balance(accountDTO.getBalance())
                .type(accountDTO.getType())
                .currency(accountDTO.getCurrency())
                .build();
        Account savedAccount = bar.save(account);
        AccountResponseDTO responseDTO = AccountResponseDTO.builder()
                .id(savedAccount.getId())
                .balance(savedAccount.getBalance())
                .created(savedAccount.getCreated())
                .currency(savedAccount.getCurrency())
                .type(savedAccount.getType())
                .build();
        return responseDTO;
    }
}
