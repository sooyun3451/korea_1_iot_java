package chapter17;

import java.util.Arrays;
import java.util.List;

public class InMemoryCustomerRepository implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        // 샘플 데이터
        return Arrays.asList(
                new Customer("John Doe", 25, "john@example.com"),
                new Customer("Jane Smith", 35, "jane@example.com"),
                new Customer("Michael Johnson", 40, "michael@example.com"),
                new Customer("Emily Davis", 28, "emily@example.com")
        );
    }
}