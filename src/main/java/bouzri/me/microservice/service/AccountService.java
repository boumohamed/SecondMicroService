package bouzri.me.microservice.service;

import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;

import java.util.List;


public interface AccountService {
    public AccountResponseDTO AddAccount(AccountRequestDTO accountDTO);
    public List<AccountResponseDTO> getAccounts();
    public AccountResponseDTO getAccount(String id);
    public AccountResponseDTO update(AccountRequestDTO accountRequestDTO, String id);

    boolean deleteAccount(String id);
}
