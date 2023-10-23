package Card.Daos;

import Card.Dtos.DebitCardDto;
import Dao.Dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DebitCardDaoList implements Dao<DebitCardDto> {

    private HashMap<String, DebitCardDto> debitCardList;
    private static DebitCardDaoList instance;

    private DebitCardDaoList() {
        this.debitCardList = new HashMap<>();
    }

    public static DebitCardDaoList getInstance() {
        if (instance == null) {
            instance = new DebitCardDaoList();
        }
        return instance;
    }

    @Override
    public boolean create(DebitCardDto debitCardDto) {
        if (debitCardDto == null) {
            return false;
        }
        debitCardList.put(debitCardDto.getNumber(), debitCardDto);
        return true;
    }

    @Override
    public List<DebitCardDto> readAll() {
        return new ArrayList<>(debitCardList.values());
    }

    @Override
    public boolean update(DebitCardDto debitCardDto) {
        String number = debitCardDto.getNumber();
        if (debitCardList.containsKey(number)) {
            debitCardList.put(number, debitCardDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(DebitCardDto debitCardDto) {
        String number = debitCardDto.getNumber();
        if (debitCardList.containsKey(number)) {
            debitCardList.remove(number);
            return true;
        }
        return false;
    }

    @Override
    public DebitCardDto read(String number) {
        return debitCardList.get(number);
    }
}
