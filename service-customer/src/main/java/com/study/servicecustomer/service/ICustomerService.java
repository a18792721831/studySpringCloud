package com.study.servicecustomer.service;


import com.study.servicedomain.beans.dto.CustomerDto;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-30
 */
public interface ICustomerService {

    void addCustomer(CustomerDto customerDto);

    List<CustomerDto> findCustomerByCode(String code);

    List<CustomerDto> findCustomerByName(String name);

    void deleteCustomerByName(String name);

    void deleteCustomerByCode(String code);

    void modifyCustomerNameByCode(String code, String name);

    List<CustomerDto> getAllCustomers();
}
