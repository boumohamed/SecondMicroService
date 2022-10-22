package bouzri.me.microservice.Entities;

import bouzri.me.microservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor @Builder

public class Account {
    @Id
    private String id;
    private Date created;
    private Double balance;
    private String currency;
    @Enumerated(value = EnumType.STRING)
    private AccountType type;

}
