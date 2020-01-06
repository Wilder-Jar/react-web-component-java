package nz.co.jar.wilder.application.services;

import com.opencsv.exceptions.CsvException;
import nz.co.jar.wilder.application.database.CustomerRepository;
import nz.co.jar.wilder.application.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CSVService csvService;
    private String customerCSVPath;

    public CustomerService(CustomerRepository customerRepository, CSVService csvService,
                           @Value("${database.source.csv}") String customerCSVPath) throws IOException, CsvException {
        this.customerRepository = customerRepository;
        this.csvService = csvService;
        this.customerCSVPath = customerCSVPath;
        initialiseDB();
    }

    public void initialiseDB() throws IOException, CsvException {
        List<Customer> customerList = csvService.loadCustomersFromCSV(customerCSVPath);

        for(Customer customer: customerList){
            customerRepository.save(customer);
        }
    }

    public List<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        Iterable<Customer> it = customerRepository.findAll();
        it.forEach(customers::add);
        return customers;
    }

    public List<Customer> getCustomersWithLastName(String lastName) {
        ArrayList<Customer> customers = new ArrayList<>();
        Iterable<Customer> it = customerRepository.findByLastName(lastName);
        it.forEach(customers::add);
        return customers;
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}
