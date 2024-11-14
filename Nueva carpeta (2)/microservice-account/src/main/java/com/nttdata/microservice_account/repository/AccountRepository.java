package com.nttdata.microservice_account.repository;

import com.nttdata.microservice_account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByClientId(String clientId);

}
