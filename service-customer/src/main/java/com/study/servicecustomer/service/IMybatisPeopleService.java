package com.study.servicecustomer.service;

import com.study.servicedomain.beans.dto.PeopleDto;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-04-03
 */
public interface IMybatisPeopleService {

    List<PeopleDto> findPeopleByName(String name);

}
