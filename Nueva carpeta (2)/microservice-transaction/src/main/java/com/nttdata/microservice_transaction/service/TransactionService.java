package com.nttdata.microservice_transaction.service;

import com.nttdata.microservice_transaction.model.Transaction;
import com.nttdata.microservice_transaction.model.TransactionInput;

public interface TransactionService {

    Transaction getTransactionById(String id);

    Transaction saveTransaction(TransactionInput transactionInput);

}
