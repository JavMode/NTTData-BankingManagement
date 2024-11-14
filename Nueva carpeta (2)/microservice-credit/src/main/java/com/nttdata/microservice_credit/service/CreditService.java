package com.nttdata.microservice_credit.service;

import com.nttdata.microservice_credit.model.Credit;
import com.nttdata.microservice_credit.model.CreditInput;

import java.util.List;

public interface CreditService {

    Credit createCredit(CreditInput creditInput);

    Credit getCreditById(String id);

    List<Credit> getCreditsOfClient(String id);

}
