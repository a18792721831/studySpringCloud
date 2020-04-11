package com.study.servicecustomer.dao.jpa;

import com.study.servicedomain.beans.Customer;
import com.study.servicedomain.neum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-30
 */
@Repository
public interface ICustomerDao extends JpaRepository<Customer, Long> {

    List<Customer> findAllByCodeAndStatus(String code, Status status);

    List<Customer> findAllByNameAndStatus(String name, Status status);

    List<Customer> findAllByStatus(Status status);
}
