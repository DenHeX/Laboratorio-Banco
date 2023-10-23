package Person.Daos;

import Dao.Dao;
import Person.Dtos.CustomerDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDaoList implements Dao<CustomerDto> {

    private HashMap<String, CustomerDto> customerList;
    private static Dao instance;
    
    public CustomerDaoList() {
        customerList = new HashMap();
    }
    public static Dao getInstance(){
        if(instance == null){
            instance = new CustomerDaoList();
        }
        return instance;
    }
    public boolean create(CustomerDto customer) {
        if (customer == null) {
            return false;
        }
        customerList.put(customer.getId(), customer);
        return true;
    }

    public CustomerDto read(String id) {
        return customerList.get(id);
    }

    public List<CustomerDto> readAll() {
        return new ArrayList<>(customerList.values());
    }

    public boolean update(CustomerDto customer) {
        return this.create(customer);
    }

    public boolean delete(CustomerDto customer) {
        return customerList.remove(customer.getId()) != null;
    }

}
