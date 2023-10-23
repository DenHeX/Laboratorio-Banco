package Transaction.Daos;

import InterfaceDaoListTransaction.DaoListTransaction;
import java.util.HashMap;
import java.util.List;
import Transaction.Dtos.TransferDto;
import java.util.ArrayList;

/**
 *
 * @author ´Felipe Chacón
 */
public class TransferDaoList implements DaoListTransaction <TransferDto> {
        
    private HashMap <String, TransferDto> transferlist;
    private static TransferDaoList instance;

    public TransferDaoList() {
        this.transferlist = new HashMap();
    }
    public static TransferDaoList getInstance(){
        if(instance == null){
            instance = new TransferDaoList();
        }
        return instance;
    }
    @Override
    public boolean create(TransferDto transfer) {
        if (transferlist == null) {
            return false;
        }
        String source = transfer.getSource().getNumber();

        if (!transferlist.containsKey(source)) {
            transferlist.put(source, transfer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public TransferDto read(String id) {
        return transferlist.get(id);
    }

    @Override
    public List<TransferDto> readAll() {
        return new ArrayList<>(transferlist.values());
    }
}
