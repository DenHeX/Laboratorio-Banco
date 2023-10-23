package Transaction.Daos;

import InterfaceDaoListTransaction.DaoListTransaction;
import Transaction.Dtos.WithdrawalDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WithdrawalDaoList implements DaoListTransaction<WithdrawalDto>{
    
     private HashMap<String,WithdrawalDto> withdrawalList;
     private static WithdrawalDaoList instance;

    private WithdrawalDaoList() {
        withdrawalList = new HashMap();
    }
    
    public static WithdrawalDaoList getInstance() {
        if (instance == null) {
            instance = new WithdrawalDaoList();
        }
        return instance;
    }

    @Override
    public boolean create(WithdrawalDto withdrawal) {
         if (withdrawal == null) {
            return false;
        }
        String source = withdrawal.getSource().getNumber();

        if (!withdrawalList.containsKey(source)) {
            withdrawalList.put(source, withdrawal);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public WithdrawalDto read(String id) {
         return withdrawalList.get(id);
    }

    @Override
    public List<WithdrawalDto> readAll() {
         return new ArrayList<>(withdrawalList.values());
    }

}