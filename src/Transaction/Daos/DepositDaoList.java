package Transaction.Daos;

import InterfaceDaoListTransaction.DaoListTransaction;
import Transaction.Dtos.DepositDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepositDaoList implements DaoListTransaction<DepositDto>{
     private HashMap<String,DepositDto> depositList;
     private static DepositDaoList instance;

    public DepositDaoList() {
        depositList = new HashMap();
    }
    
     public static DepositDaoList getInstance() {
        if (instance == null) {
            instance = new DepositDaoList();
        }
        return instance;
    }

     @Override
    public boolean create(DepositDto deposit) {
        if (depositList == null) {
            return false;
        }
        String source = deposit.getSource().getNumber();

        if (!depositList.containsKey(source)) {
            depositList.put(source, deposit);
            return true;
        } else {
            return false;
        }
    }

     @Override
    public DepositDto read(String id) {
        return depositList.get(id);
    }

     @Override
    public List<DepositDto> readAll() {
        return new ArrayList<>(depositList.values());
    }
}