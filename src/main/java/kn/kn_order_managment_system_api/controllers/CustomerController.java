package kn.kn_order_managment_system_api.controllers;
import jakarta.validation.Valid;
import kn.kn_order_managment_system_api.controllers.models.CustomerSearchCriteria;
import kn.kn_order_managment_system_api.controllers.models.CustomerSpecifications;
import kn.kn_order_managment_system_api.dto.CustomerDTO;
import kn.kn_order_managment_system_api.entity.Customer;
import kn.kn_order_managment_system_api.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDTO> showAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(required = true) int id) throws Exception {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO addCustomer(@RequestBody @Valid CustomerDTO customer) throws Exception {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers_delete/{id}")
    public void deleteCustomer(@PathVariable(required = true) int id) throws Exception {
        customerService.deleteCustomer(id);
    }
    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestBody CustomerSearchCriteria criteria) throws Exception {
        Specification <Customer> specification = CustomerSpecifications.buildSpecification(criteria);
        return customerService.findAll(specification);
    }
}
