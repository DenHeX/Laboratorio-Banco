package Account.Daos;

import Account.Dtos.AccountDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DollarAccountDaoList implements Dao<AccountDto>{
    private HashMap<String,AccountDto> dollarAccountList;
    private static DollarAccountDaoList instance;
    
    public DollarAccountDaoList(){
        dollarAccountList = new HashMap();
    }
    public static DollarAccountDaoList getInstance(){
        if(instance == null){
            instance = new DollarAccountDaoList();
        }
        return instance;
    }
    @Override
    public boolean create(AccountDto obj) {
        if (dollarAccountList.containsKey(obj.getNumber())) {
            return false;
        }
        dollarAccountList.put(obj.getNumber(), obj);
        return true;
    }

    @Override
    public AccountDto read(String id) {
        return dollarAccountList.get(id);
    }

    @Override
    public List<AccountDto> readAll() {
        return new ArrayList<>(dollarAccountList.values());
    }

    @Override
    public boolean update(AccountDto obj) {
        if (dollarAccountList.containsKey(obj.getNumber())) {
            dollarAccountList.put(obj.getNumber(), obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(AccountDto obj) {
        if (dollarAccountList.containsKey(obj.getNumber())) {
            dollarAccountList.remove(obj.getNumber());
            return true;
        }
        return false;
    }
}
