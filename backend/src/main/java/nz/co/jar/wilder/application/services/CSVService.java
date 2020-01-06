package nz.co.jar.wilder.application.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import nz.co.jar.wilder.application.models.Customer;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    public List<Customer> loadCustomersFromCSV(String csvLocation) throws IOException, CsvException {

        List<Customer> customers = new ArrayList<>();

        CSVReader reader = new CSVReader(new FileReader(csvLocation));
        List<String[]> input = reader.readAll();

        for (int i = 1; i < input.size(); i++) {
            String[] strings = input.get(i);
            customers.add(new Customer(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5],
                    strings[6], strings[7], strings[8], strings[9], strings[10]));
        }

        return customers;
    }
}
