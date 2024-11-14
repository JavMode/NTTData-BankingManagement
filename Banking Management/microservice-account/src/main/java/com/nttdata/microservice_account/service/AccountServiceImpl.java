package com.nttdata.microservice_account.service;

import com.nttdata.microservice_account.model.Account;
import com.nttdata.microservice_account.model.AccountInput;
import com.nttdata.microservice_account.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(AccountInput accountInput) {
        Account account = new Account();
        account.setAmount(0F);
        account.setAccountType(Account.AccountTypeEnum.fromValue(accountInput.getAccountType().toString()));
        account.setClientId(accountInput.getClientId());
        accountRepository.save(account);
        return account;
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccountById(Account accountInput) {
        Account account = accountRepository.findById(accountInput.getId()).get();

        account.setAmount(accountInput.getAmount());
        account.setAccountType(accountInput.getAccountType());
        account.setClientId(accountInput.getClientId());

        accountRepository.save(account);
        return account;
    }

    @Override
    public Account getAccountById(String id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void deleteAccountById(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> getAccountsOfClient(String id) {
        return accountRepository.findByClientId(id);
    }
}
