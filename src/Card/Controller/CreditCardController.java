package Card.Controller;

import Card.CreditCard;
import Controller.Controller;
import Dao.Dao;
import Views.View;
import java.util.List;

/**
 *
 * @author ´Felipe Chacón
 */
public class CreditCardController implements Controller<CreditCard> {
    
    private View view;
    private Dao dao;

    public CreditCardController(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(CreditCard obj) {
        List<CreditCard> existingCreditCards = dao.readAll();

        for (CreditCard creditCard : existingCreditCards) {
            if (creditCard.getNumber().equals(obj.getNumber())) {
                view.displayMessage("Número de tarjeta duplicado");
                return false;
            }
        }

        if (dao.create(obj)) {
            view.displayMessage("Tarjeta de crédito creada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al crear la tarjeta de crédito.");
            return false;
        }
    }

    @Override
    public CreditCard read(String id) {
        CreditCard creditCard = (CreditCard) dao.read(id);

        if (creditCard == null) {
            view.displayMessage("Tarjeta de crédito no encontrada.");
        } else {
            view.display(creditCard);
        }

        return creditCard;
    }

    @Override
    public List<CreditCard> readAll() {
        List<CreditCard> creditCards = dao.readAll();

        if (!creditCards.isEmpty()) {
            for (CreditCard creditCard : creditCards) {
                view.display(creditCard);
            }
            return creditCards;
        } else {
            view.displayMessage("No hay tarjetas de crédito disponibles.");
            return null;
        }
    }

    @Override
    public boolean update(CreditCard obj) {
        if (dao.update(obj)) {
            view.displayMessage("Tarjeta de crédito actualizada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al actualizar la tarjeta de crédito.");
            return false;
        }
    }

    @Override
    public boolean delete(CreditCard obj) {
     if (dao.delete(obj)) {
            view.displayMessage("Tarjeta de crédito eliminada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al eliminar la tarjeta de crédito.");
            return false;
        }
    }
}
