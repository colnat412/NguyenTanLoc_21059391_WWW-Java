package fit.iuh.edu.vn.services;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.repositories.AccountRepository;

public class AccountServices {
    private AccountRepository accountRepository;

    public AccountServices(){
        accountRepository = new AccountRepository();
    }

    public Account findAccountByEmail(String email){
        return accountRepository.findAccountByEmail(email);
    }
}
