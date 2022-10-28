package bouzri.me.microservice.service;

import bouzri.me.microservice.Entities.Account;
import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;
import bouzri.me.microservice.mappers.AccountMapper;
import bouzri.me.microservice.repositories.BankAccountrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private BankAccountrepository bar;
    private AccountMapper mapper;
    @Override
    public AccountResponseDTO AddAccount(AccountRequestDTO accountDTO) {
        Account account = mapper.fromAccountDTO(accountDTO);
        Account savedAccount = bar.save(account);
        AccountResponseDTO responseDTO = mapper.fromAccount(savedAccount);
        return responseDTO;
    }

    @Override
    public List<AccountResponseDTO> getAccounts() {
        List<Account> accounts = bar.findAll();
        List<AccountResponseDTO> accountResponseDTOS = accounts.stream()
                .map(a ->
                        mapper.fromAccount(a)).collect(Collectors.toList());
        return accountResponseDTOS;
    }

    @Override
    public AccountResponseDTO getAccount(String id) {
        Account account = bar.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s Not Found", id)));
        AccountResponseDTO responseDTO = mapper.fromAccount(account);
        return responseDTO;
    }

    @Override
    public AccountResponseDTO update(AccountRequestDTO accountRequestDTO, String id) {
        Account acc = bar.findById(id).orElseThrow();
        acc.setId(id);
        if (accountRequestDTO.getBalance() != null) acc.setBalance(accountRequestDTO.getBalance());
        if (accountRequestDTO.getCurrency() != null) acc.setCurrency(accountRequestDTO.getCurrency());
        if (accountRequestDTO.getType() != null) acc.setType(accountRequestDTO.getType());
        Account saved = bar.save(acc);
        return mapper.fromAccount(saved);

    }

    @Override
    public boolean deleteAccount(String id) {
        Account account = bar.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account \' %s \' not found", id)));
        if (account == null)
            return false;
        bar.deleteById(id);
        return true;

    }

}
