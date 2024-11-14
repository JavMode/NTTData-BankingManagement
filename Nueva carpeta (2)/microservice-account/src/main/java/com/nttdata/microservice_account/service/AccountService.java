package com.nttdata.microservice_account.service;

import com.nttdata.microservice_account.model.Account;
import com.nttdata.microservice_account.model.AccountInput;

import java.util.List;

public interface AccountService {

    Account createAccount(AccountInput accountInput);

    List<Account> getAccounts();

    Account updateAccountById(Account client);

    Account getAccountById(String id);

    void deleteAccountById(String id);

    List<Account> getAccountsOfClient(String id);

}
