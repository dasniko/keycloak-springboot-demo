package dasniko.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Component
class CustomerRepository {

    private static List<Customer> customers = Arrays.asList(
            new Customer(1L,"San Francisco","Twitter Inc.","1355 Market Street","CA 94103","USA"),
            new Customer(2L,"Menlo Park","Facebook Inc.","1 Hacker Way","CA 94025","USA"),
            new Customer(3L,"Mountain View","Google Inc.","1600 Amphitheatre Parkway","CA 94043","USA"),
            new Customer(4L,"Redwood Shores","Oracle Corp.","500 Oracle Parway","CA 94065","USA"),
            new Customer(5L,"Los Gatos","Netflix Inc.","100 Winchester Circle","CA 95932","USA")
    );

    List<Customer> findAll() {
        return customers;
    }

    Customer findOne(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().get();
    }
}
