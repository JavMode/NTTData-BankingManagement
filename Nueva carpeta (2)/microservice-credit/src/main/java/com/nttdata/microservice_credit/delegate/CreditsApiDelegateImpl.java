package com.nttdata.microservice_credit.delegate;

import com.nttdata.microservice_credit.api.CreditsApiDelegate;
import com.nttdata.microservice_credit.model.Credit;
import com.nttdata.microservice_credit.model.CreditInput;
import com.nttdata.microservice_credit.service.CreditServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditsApiDelegateImpl implements CreditsApiDelegate {

    private final CreditServiceImpl creditService;

    public CreditsApiDelegateImpl(CreditServiceImpl creditService) {
        this.creditService = creditService;
    }

    @Override
    public ResponseEntity<Credit> createCredit(CreditInput creditInput) {
        return ResponseEntity.ok(creditService.createCredit(creditInput));
    }

    @Override
    public ResponseEntity<Credit> findCreditById(String id) {
        return ResponseEntity.ok(creditService.getCreditById(id));
    }

    @Override
    public ResponseEntity<List<Credit>> getCreditsOfClient(String id) {
        return ResponseEntity.ok(creditService.getCreditsOfClient(id));
    }

}
