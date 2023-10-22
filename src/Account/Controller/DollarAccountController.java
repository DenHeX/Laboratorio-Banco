package Account.Controller;

import Account.DollarAccount;
import Controller.Controller;
import Dao.Dao;
import Views.View;
import java.util.List;

public class DollarAccountController implements Controller<DollarAccount> {
    
    private View view;
    private Dao dao;

    @Override
    public boolean create(DollarAccount obj) {
        List<DollarAccount> existingAccounts = dao.readAll();

        for (DollarAccount account : existingAccounts) {
            if (account.getNumber().equals(obj.getNumber())) {
                view.displayMessage("Número de cuenta en dólares duplicado");
                return false;
            }
        }

        if (dao.create(obj)) {
            view.displayMessage("Cuenta en dólares creada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al crear la cuenta en dólares.");
            return false;
        }
    }

    @Override
    public DollarAccount read(String id) {
        DollarAccount account = (DollarAccount) dao.read(id);

        if (account == null) {
            view.displayMessage("Cuenta en dólares no encontrada.");
        } else {
            view.display(account);
        }

        return account;
    }

    @Override
    public List<DollarAccount> readAll() {
        List<DollarAccount> accounts = dao.readAll();

        if (!accounts.isEmpty()) {
            for (DollarAccount account : accounts) {
                view.display(account);
            }
            return accounts;
        } else {
            view.displayMessage("No hay cuentas en dólares disponibles.");
            return null;
        }
    }

    @Override
    public boolean update(DollarAccount obj) {
        if (dao.update(obj)) {
            view.displayMessage("Cuenta en dólares actualizada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al actualizar la cuenta en dólares.");
            return false;
        }
    }

    @Override
    public boolean delete(DollarAccount obj) {
        if (dao.delete(obj)) {
            view.displayMessage("Cuenta en dólares eliminada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al eliminar la cuenta en dólares.");
            return false;
        }
    }
}
