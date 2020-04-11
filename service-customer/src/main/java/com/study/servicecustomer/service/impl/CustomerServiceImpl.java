package com.study.servicecustomer.service.impl;

import com.study.servicecustomer.dao.jpa.ICustomerDao;
import com.study.servicecustomer.service.ICustomerService;
import com.study.servicedomain.beans.Customer;
import com.study.servicedomain.beans.dto.CustomerDto;
import com.study.servicedomain.neum.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-03-30
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer, Customer.class);
        customerDao.save(customer);
    }

    @Override
    public List<CustomerDto> findCustomerByCode(String code) {
        return customerDao.findAllByCodeAndStatus(code, Status.VALID).stream().map(c -> {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(c, customerDto, CustomerDto.class);
            return customerDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> findCustomerByName(String name) {
        return customerDao.findAllByNameAndStatus(name, Status.VALID).stream().map(c -> {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(c, customerDto, CustomerDto.class);
            return customerDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomerByName(String name) {
        customerDao.saveAll(
                customerDao.findAllByNameAndStatus(name, Status.VALID).stream().map(c -> {
                    c.setStatus(Status.INVALID);
                    return c;
                }).collect(Collectors.toList()));

    }

    @Override
    public void deleteCustomerByCode(String code) {
        customerDao.saveAll(customerDao.findAllByCodeAndStatus(code, Status.VALID).stream().map(c -> {
            c.setStatus(Status.INVALID);
            return c;
        }).collect(Collectors.toList()));
    }

    @Override
    public void modifyCustomerNameByCode(String code, String name) {
        customerDao.saveAll(customerDao.findAllByCodeAndStatus(code, Status.VALID).stream().map(c -> {
            c.setName(name);
            return c;
        }).collect(Collectors.toList()));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerDao.findAllByStatus(Status.VALID).stream().map(c -> {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(c, customerDto, CustomerDto.class);
            return customerDto;
        }).collect(Collectors.toList());
    }
}
