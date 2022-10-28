package bouzri.me.microservice.Entities;

import bouzri.me.microservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToOne
    private Customer customer;

}
