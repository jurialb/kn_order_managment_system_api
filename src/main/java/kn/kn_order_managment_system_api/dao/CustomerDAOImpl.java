package kn.kn_order_managment_system_api.dao;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kn.kn_order_managment_system_api.dto.CustomerDTO;
import kn.kn_order_managment_system_api.entity.Customer;
import kn.kn_order_managment_system_api.entity.OrderLine;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CustomerDTO>  getAllCustomers() {
        Query query = entityManager.createQuery("from Customer ");
        List<CustomerDTO>  allCustomers = query.getResultList();
        return allCustomers;
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer newCustomer = modelMapper.map(customerDTO, Customer.class);
        entityManager.merge(newCustomer);

    }

    @Override
    public CustomerDTO getCustomer(int RegistrationCode) {
        Customer customerFromDB =  entityManager.find(Customer.class,RegistrationCode);
        CustomerDTO customerDTO = this.modelMapper.map(customerFromDB, CustomerDTO.class);
        return customerDTO;
    }

    @Override
    public void deleteCustomer(int RegistrationCode) {
        Query query = entityManager.createQuery("delete from Customer where registrationCode=:RegistrationCode");
        query.executeUpdate();

    }
}
