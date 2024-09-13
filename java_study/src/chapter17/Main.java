package chapter17;

public class Main {
	public static void main(String[] args) {
		 // Repository, Service, Controller 설정
        CustomerRepository customerRepository = new InMemoryCustomerRepository();
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerController customerController = new CustomerController(customerService);

        // 고객 정보 출력
        customerController.printCustomerDetails();
	}
}