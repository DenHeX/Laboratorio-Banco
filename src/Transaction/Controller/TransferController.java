package Transaction.Controller;

import Controller.Controller;
import Dao.Dao;
import Transaction.Daos.TransferDaoList;
import Transaction.Transaction;
import Transaction.Transfer;
import Views.View;
import java.util.List;

public class TransferController implements Controller<Transfer>{
    private View view;
    private Dao dao;

    public TransferController(View view, TransferDaoList list) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(Transfer obj) {
        if (dao.create(obj)) {
            view.displayMessage("Depósito registrado con éxito.");
            return true;
        } else {
            view.displayMessage("Error al registrar el depósito.");
            return false;
        }    
    }

    @Override
    public Transfer read(String id) {
        Transfer transaction = (Transfer) dao.read(id);

        if (transaction == null) {
            view.displayMessage("Transacción no encontrada.");
        } else {
            view.display(transaction);
        }
        return transaction;
    }

    @Override
    public List<Transfer> readAll() {
        List<Transfer> transactions = dao.readAll();

        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                view.display(transaction);
            }
            return transactions;
        } else {
            view.displayMessage("No hay transacciones disponibles.");
            return null;
        } 
    }

    @Override
    public boolean update(Transfer obj) {
        if (dao.update(obj)) {
            view.displayMessage("Transacción actualizada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al actualizar la transacción.");
            return false;
        } 
    }

    @Override
    public boolean delete(Transfer obj) {
        if (dao.delete(obj)) {
            view.displayMessage("Transacción eliminada con éxito.");
            return true;
        } else {
            view.displayMessage("Error al eliminar la transacción.");
            return false;
        }
    }
}