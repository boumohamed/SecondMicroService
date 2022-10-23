package bouzri.me.microservice.service;

import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;


public interface AccountService {
    public AccountResponseDTO AddAccount(AccountRequestDTO accountDTO);
}
