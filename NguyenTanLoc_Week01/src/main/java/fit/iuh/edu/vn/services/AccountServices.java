package fit.iuh.edu.vn.services;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.repositories.AccountRepository;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;

    public AccountServices(){
        accountRepository = new AccountRepository();
    }

    public void create(Account account){
        accountRepository.create(account);
    }

    public void update(Account account){
        accountRepository.update(account);
    }

    public void delete(Account account){
        accountRepository.delete(account);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account findAccountByEmail(String email){
        return accountRepository.findAccountByEmail(email);
    }
}
