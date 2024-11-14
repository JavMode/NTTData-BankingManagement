package com.nttdata.microservice_credit.repository;

import com.nttdata.microservice_credit.model.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends MongoRepository<Credit, String> {

    List<Credit> findByClientId(String clientId);

}
