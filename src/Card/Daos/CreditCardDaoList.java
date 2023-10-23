package Card.Daos;

import Card.Dtos.CreditCardDto;
import Dao.Dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreditCardDaoList implements Dao<CreditCardDto> {

    private HashMap<String, CreditCardDto> creditcardlist;
    private static CreditCardDaoList instance;

    private CreditCardDaoList() {
        this.creditcardlist = new HashMap();
    }

    public static CreditCardDaoList getInstance() {
        if (instance == null) {
            instance = new CreditCardDaoList();
        }
        return instance;
    }

    @Override
    public boolean create(CreditCardDto creditCardDto) {
        if (creditCardDto == null) {
            return false;
        }
        creditcardlist.put(creditCardDto.getNumber(), creditCardDto);
        return true;
    }

    @Override
    public List<CreditCardDto> readAll() {
        return new ArrayList<>(creditcardlist.values());
    }

    @Override
    public boolean update(CreditCardDto creditCardDto) {
        String number = creditCardDto.getNumber();
        if (creditcardlist.containsKey(number)) {
            creditcardlist.put(number, creditCardDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(CreditCardDto creditCardDto) {
        String number = creditCardDto.getNumber();
        if (creditcardlist.containsKey(number)) {
            creditcardlist.remove(number);
            return true;
        }
        return false;
    }

    @Override
    public CreditCardDto read(String number) {
        return creditcardlist.get(number);
    }

}
