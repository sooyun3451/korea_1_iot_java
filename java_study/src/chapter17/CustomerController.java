package chapter17;

import java.util.List;

public class CustomerController {
    private final CustomerService customerService;

    // 생성자
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 고객 목록 출력 및 30세 이상 고객 필터링 결과 출력
    public void printCustomerDetails() {
        // 전체 고객 목록 출력
        List<Customer> allCustomers = customerService.getCustomersAbove30();
        System.out.println("고객 목록:");
        allCustomers.forEach(System.out::println);

        // 30세 이상 고객 목록 출력
        System.out.println("\n30세 이상 고객 목록:");
        List<Customer> customersAbove30 = customerService.getCustomersAbove30();
        customersAbove30.forEach(System.out::println);

        // 고객들의 나이 합계 출력
        int totalAge = customerService.getTotalAge();
        System.out.println("\n고객들의 나이 합계: " + totalAge);
    }
}