package Person.Controller;

import Controller.Controller;
import Dao.Dao;
import Person.Customer;
import Person.Dtos.CustomerDto;
import Views.View;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

public class CustomerController implements Controller<Customer> {

    private View view;
    private Dao dao;

    public CustomerController(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean create(Customer customer) {
        CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getName(), customer.getDateOfBirth(), customer.getPhone(), customer.getEmail(), customer.getAddress());

        if (dao.create(customerDto)) {
            view.displayMessage("Cliente agregado correctamente");
            return true;
        } else {
            view.displayMessage("Error al agregar cliente");
            return false;
        }
    }

    @Override
    public Customer read(String id) {
        CustomerDto customerDto = (CustomerDto) dao.read(id);
        if (customerDto == null) {
            view.displayMessage("Cliente no encontrado");
        } else {
            Customer customer = new Customer(customerDto.getId(), customerDto.getName(), (Date) customerDto.getDateOfBirth(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getAddress());
            view.display(customer);
            return customer;
        }
        return null;
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerDto> customerDtos = dao.readAll();

        for (CustomerDto customerDto : customerDtos) {
            Customer customer = new Customer(customerDto.getId(), customerDto.getName(), (Date) customerDto.getDateOfBirth(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getAddress());
            customers.add(customer);
        }

        return customers;
    }

    @Override
    public boolean update(Customer customer) {
        if (dao.read(customer.getId()) == null) {
            view.displayMessage("Cliente no encontrado");
            return false;
        } else {
            CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getName(), customer.getDateOfBirth(), customer.getPhone(), customer.getEmail(), customer.getAddress());
            if (dao.update(customerDto)) {
                view.displayMessage("Cliente actualizado correctamente");
                return true;
            } else {
                view.displayMessage("Error al actualizar cliente");
                return false;
            }
        }
    }

    @Override
    public boolean delete(Customer customer) {
        if (dao.read(customer.getId()) == null) {
            view.displayMessage("Cliente no encontrado");
            return false;
        } else {
            if (dao.delete(customer.getId())) {
                view.displayMessage("Cliente eliminado correctamente");
                return true;
            } else {
                view.displayMessage("Error al eliminar cliente");
                return false;
            }
        }
    }
}
