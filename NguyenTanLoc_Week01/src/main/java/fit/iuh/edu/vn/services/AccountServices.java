package fit.iuh.edu.vn.services;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.repositories.AccountRepository;

import java.util.List;

public class AccountServices {
    private AccountRepository accountRepository;

    public AccountServices(){
        accountRepository = new AccountRepository();
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account findAccountByEmail(String email){
        return accountRepository.findAccountByEmail(email);
    }
}
