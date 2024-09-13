package chapter17;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerRepository customerRepository;

    // 생성자
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 고객들의 나이 합계를 구하는 메서드
    public int getTotalAge() {
        return customerRepository.findAll()
                .stream()
                .mapToInt(Customer::getAge)
                .sum();
    }

    // 나이가 30 이상인 고객 목록을 반환하는 메서드
    public List<Customer> getCustomersAbove30() {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getAge() >= 30)
                .collect(Collectors.toList());
    }
}