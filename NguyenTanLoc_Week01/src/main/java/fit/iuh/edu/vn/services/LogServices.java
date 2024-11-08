package fit.iuh.edu.vn.services;

import fit.iuh.edu.vn.entities.Log;
import fit.iuh.edu.vn.repositories.AccountRepository;
import fit.iuh.edu.vn.repositories.LogRepository;

import java.util.List;

public class LogServices {
    private LogRepository logRepository;

    public LogServices(){
        logRepository = new LogRepository();
    }

    public void create(Log log){
        logRepository.create(log);
    }

    public void update(Log log){
        logRepository.update(log);
    }

    public List<Log> findLogByAccountId(String accountId){
        return logRepository.findLogByAccountId(accountId);
    }

    public Log findIdLast(){
        return logRepository.findIdLast();
    }
}
