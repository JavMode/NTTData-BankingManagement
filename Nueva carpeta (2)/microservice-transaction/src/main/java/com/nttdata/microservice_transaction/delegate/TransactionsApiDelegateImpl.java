package com.nttdata.microservice_transaction.delegate;

import com.nttdata.microservice_transaction.api.TransactionsApiDelegate;
import com.nttdata.microservice_transaction.model.Transaction;
import com.nttdata.microservice_transaction.model.TransactionInput;
import com.nttdata.microservice_transaction.service.TransactionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionsApiDelegateImpl implements TransactionsApiDelegate {

    private final TransactionServiceImpl transactionService;

    public TransactionsApiDelegateImpl(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<Transaction> findTransactionById(String id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @Override
    public ResponseEntity<Transaction> createTransaction(TransactionInput transactionInput) {
        return ResponseEntity.ok(transactionService.saveTransaction(transactionInput));
    }
}
