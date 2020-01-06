package nz.co.jar.wilder.application.controllers;

import nz.co.jar.wilder.application.models.Customer;
import nz.co.jar.wilder.application.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private CustomerService customerService;

    public TestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping("/")
    public List<Customer> getCustomers(){
        return customerService.getCustomersWithLastName("Klar");
    }

}
