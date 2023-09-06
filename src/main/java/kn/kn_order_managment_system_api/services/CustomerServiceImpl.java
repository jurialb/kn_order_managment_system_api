package kn.kn_order_managment_system_api.services;

import jakarta.transaction.Transactional;
import kn.kn_order_managment_system_api.dao.CustomerDAO;
import kn.kn_order_managment_system_api.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<CustomerDTO> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDAO.saveCustomer(customerDTO);
    }

    @Override
    @Transactional
    public CustomerDTO getCustomer(int customer_id) {
        return customerDAO.getCustomer(customer_id);
    }

    @Transactional
    @Override
    public void deleteCustomer(int customer_id) {
        customerDAO.deleteCustomer(customer_id);
    }
}
