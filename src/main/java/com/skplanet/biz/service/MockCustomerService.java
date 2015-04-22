package com.skplanet.biz.service;

import com.skplanet.biz.domain.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

        import java.util.ArrayList;
        import java.util.LinkedHashMap;
        import java.util.List;
        import java.util.Map;

@Service("customerService")
public class MockCustomerService implements CustomerService {
    // 예제용 Mock 구현이므로
    // synchronized 등의 동기처리는 전혀 하지 않는다.
    private Map<Integer, Customer> customerMap
            = new LinkedHashMap<Integer, Customer>();

    private int nextId = 1;

    private boolean isExists(int id) {
        return customerMap.containsKey(id);
    }

    public List<Customer> findAll() {
        return new ArrayList<Customer>(customerMap.values());
    }

    public Customer findById(int id) throws Exception {
        if (!isExists(id)) {
            throw new Exception();
        }
        return customerMap.get(id);
    }

    public void register(Customer customer) {
        customer.setId(nextId++);
        customerMap.put(customer.getId(), customer);
    }

    public void update(Customer customer) throws Exception {
        if (!isExists(customer.getId())) {
            throw new Exception();
        }
        customerMap.put(customer.getId(), customer);
    }

    public void delete(int id) throws Exception {
        if (!isExists(id)) {
            throw new Exception();
        }
        customerMap.remove(id);
    }

    public boolean isFreeEmailCustomer(Customer customer) {
        // 이 구현에서는
        // Customer#isFreeEmail을 호출하고 결과를 반환하기만 한다
        return customer.isFreeEmail();
    }

    @PostConstruct
    public void initCustomer() {
        nextId = 1;

        register(new Customer("자룡", "서울시 강남구", "jaryong@aa.bb.cc"));
        register(new Customer("길동", "서울시 강서구", "kildong@aa.bb.cc"));
        register(new Customer("철수", "서울시 노원구", "chulsoo@aa.bb.cc"));
    }
}
