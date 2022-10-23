package bouzri.me.microservice.Entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Account.class, name = "p1")
public interface AccountP {
    public String getId();
    public String getCurrency();
    public String getType();
}
