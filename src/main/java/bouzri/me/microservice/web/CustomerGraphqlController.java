package bouzri.me.microservice.web;

import bouzri.me.microservice.Entities.Account;
import bouzri.me.microservice.Entities.Customer;
import bouzri.me.microservice.dtos.AccountRequestDTO;
import bouzri.me.microservice.dtos.AccountResponseDTO;
import bouzri.me.microservice.repositories.BankAccountrepository;
import bouzri.me.microservice.repositories.CustomerRepository;
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
public class CustomerGraphqlController {
    private CustomerRepository cr;



    @QueryMapping
    public List<Customer> customersList()
    {
        return cr.findAll();
    }

    /*@QueryMapping
    public Customer customerById(@Argument Long id)
    {
        return cr.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account \' %s \' not Found", id)));
    }
    @MutationMapping
    public AccountResponseDTO addCustomer(@Argument AccountRequestDTO account)
    {
        return null;
    }

    @MutationMapping
    public AccountResponseDTO updateCustomer(@Argument String id, @Argument AccountRequestDTO account)
    {
        return null;
    }

    @MutationMapping
    public boolean deleteAcoount( @Argument String id)
    {
        return false;
    }*/
}
