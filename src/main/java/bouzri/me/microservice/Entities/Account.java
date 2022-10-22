package bouzri.me.microservice.Entities;

import bouzri.me.microservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor @Builder

public class Account {
    @Id
    private String id;
    private Date created;
    private double balance;
    private String currency;
    private AccountType type;

}
