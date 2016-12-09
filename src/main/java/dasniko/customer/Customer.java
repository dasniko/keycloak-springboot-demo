package dasniko.customer;

import lombok.Value;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Value
class Customer {
    private final Long id;
    private final String city;
    private final String name;
    private final String street;
    private final String zip;
    private final String country;
}
