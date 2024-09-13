package chapter17;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();  // 모든 고객 목록을 반환
}