package nz.co.jar.wilder.application.controllers;

import nz.co.jar.wilder.application.models.Customer;
import nz.co.jar.wilder.application.services.CustomerService;
import nz.co.jar.wilder.application.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;



    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Optional<Customer> customerById = customerService.getCustomerById(id);

        if(customerById.isPresent()){
            return new ResponseEntity<Customer>(customerById.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }
}
