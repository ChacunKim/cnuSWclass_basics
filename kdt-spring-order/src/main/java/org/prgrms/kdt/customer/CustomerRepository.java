package org.prgrms.kdt.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Customer insult(Customer customer);

    Customer update(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(UUID customerId);
    Optional<Customer> findByName(UUID customerId);
    Optional<Customer> findByEmail(UUID customerId);

    void deleteAll();

}
