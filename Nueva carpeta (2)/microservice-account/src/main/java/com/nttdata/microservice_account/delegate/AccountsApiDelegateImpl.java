package com.nttdata.microservice_account.delegate;

import com.nttdata.microservice_account.api.AccountsApiDelegate;
import com.nttdata.microservice_account.model.Account;
import com.nttdata.microservice_account.model.AccountInput;
import com.nttdata.microservice_account.service.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsApiDelegateImpl implements AccountsApiDelegate{

    private final AccountServiceImpl accountService;

    public AccountsApiDelegateImpl(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<Account> createAccount(AccountInput accountInput) {
        return ResponseEntity.ok(accountService.createAccount(accountInput));
    }

    @Override
    public ResponseEntity<Account> updateAccount(Account account) {
        return ResponseEntity.ok(accountService.updateAccountById(account));
    }

    @Override
    public ResponseEntity<List<Account>> getAccountsOfClient(String id) {
        return ResponseEntity.ok(accountService.getAccountsOfClient(id));
    }

    @Override
    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @Override
    public ResponseEntity<Account> findAccountById(String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @Override
    public ResponseEntity<Void> deleteAccountById(String id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().build();
    }
}
