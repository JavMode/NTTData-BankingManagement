package com.nttdata.microservice_transaction.service;

import com.nttdata.microservice_transaction.model.Transaction;
import com.nttdata.microservice_transaction.model.TransactionInput;
import com.nttdata.microservice_transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction saveTransaction(TransactionInput transactionInput) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(Transaction.TransactionTypeEnum.fromValue(transactionInput.getTransactionType().getValue()));
        transaction.setAmount(transactionInput.getAmount());
        transaction.setCardId(transactionInput.getCardId());
        transaction.setDatetime(OffsetDateTime.now());
        transactionRepository.save(transaction);
        return transaction;
    }
}
