package nz.co.jar.wilder.application.services;

import nz.co.jar.wilder.application.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class CSVServiceTest {

    private CSVService csvService;

    @BeforeEach
    void setUp() {
        csvService = new CSVService();
    }

    @Test
    void loadCustomersFromCSV() throws Exception {

        String csvLocation = "src/test/resources/test_csv.csv";

        //  Given


        //  When

        List<Customer> customers = csvService.loadCustomersFromCSV(csvLocation);

        //  Then

        assertThat("Customer count does not match input", customers.size() == 500);
        assertThat("Headers were incorrectly included", customers.get(0).getFirstName() != "first_name");


    }
}