package com.nttdata.microservice_credit.service;

import com.nttdata.microservice_credit.model.Credit;
import com.nttdata.microservice_credit.model.CreditInput;
import com.nttdata.microservice_credit.repository.CreditRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class CreditServiceImpl implements CreditService{

    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Credit createCredit(CreditInput creditInput) {

        if(Objects.equals(creditInput.getCardType().toString(), "personal")){
            List<Credit> list = creditRepository.findByClientId(creditInput.getClientId());
            if(list!=null && !list.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST
                );
            }
        }

        Credit credit = new Credit();
        credit.setCreditLimit(creditInput.getCreditLimit());
        credit.setCardType(Credit.CardTypeEnum.fromValue(creditInput.getCardType().toString()));
        credit.setClientId(creditInput.getClientId());
        credit.setOutstandingBalance(0F);
        creditRepository.save(credit);
        return credit;
    }

    @Override
    public Credit getCreditById(String id) {
        return creditRepository.findById(id).get();
    }

    @Override
    public List<Credit> getCreditsOfClient(String id) {
        return creditRepository.findByClientId(id);
    }
}
