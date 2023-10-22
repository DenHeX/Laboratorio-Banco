package Account.Daos;

import Account.Dtos.AccountDto;
import Account.Dtos.ColonAccountDto;
import java.util.ArrayList;
import java.util.List;

public class ColonAccountDaoList implements Dao<AccountDto> {
    private ArrayList<ColonAccountDto> listColonAccount;
    private static ColonAccountDaoList instance;
    
    private ColonAccountDaoList() {
        listColonAccount = new ArrayList();
    }

     public static ColonAccountDaoList getInstance() {
        if (instance == null) {
            instance = new ColonAccountDaoList();
        }
        return instance;
    }

    @Override
    public boolean create(AccountDto obj) {    
        if (obj instanceof ColonAccountDto) {
            ColonAccountDto colonAccount = (ColonAccountDto) obj;
            if (!listColonAccount.contains(colonAccount)) {
                listColonAccount.add(colonAccount);
                return true; // Cuenta creada con éxito
            }
        }
        return false;
    }

    @Override
    public AccountDto read(String id) {
        for (ColonAccountDto colonAccount : listColonAccount) {
            if (colonAccount.getNumber().equals(id)) {
                return colonAccount; // Devolver la cuenta si se encuentra
            }
        }
        return null;
    }

    @Override
    public List<AccountDto> readAll() {
        return new ArrayList<>(listColonAccount);
    }

    @Override
    public boolean update(AccountDto obj) {
        if (obj instanceof ColonAccountDto) {
            ColonAccountDto colonAccount = (ColonAccountDto) obj;
            int index = listColonAccount.indexOf(colonAccount);
            if (index != -1) {
                listColonAccount.set(index, colonAccount);
                return true;
            }
        }
        return false; 
    }

    @Override
    public boolean delete(AccountDto obj) {
        if (obj instanceof ColonAccountDto) {
            ColonAccountDto colonAccount = (ColonAccountDto) obj;
            if (listColonAccount.remove(colonAccount)) {
                return true;
            }
        }
        return false;
    }
}
