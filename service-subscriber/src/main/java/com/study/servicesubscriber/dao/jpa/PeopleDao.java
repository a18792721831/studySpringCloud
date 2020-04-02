package com.study.servicesubscriber.dao.jpa;

import com.study.servicedomain.beans.People;
import com.study.servicedomain.neum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
@Repository
public interface PeopleDao extends JpaRepository<People, Long> {

    List<People> findAllByCodeAndStatus(String code, Status status);

    List<People> findAllByNameAndStatus(String name, Status status);

    List<People> findAllByStatus(Status status);
}
