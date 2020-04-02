package com.study.servicesubscriber.service;


import com.study.servicedomain.beans.dto.PeopleDto;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
public interface PeopleService {

    void addPeople(PeopleDto peopleDto);

    List<PeopleDto> findPeopleByCode(String code);

    List<PeopleDto> findPeopleByName(String name);

    void modifyPeople(PeopleDto peopleDto);

    void modifyPeopleNameByCode(String code, String name);

    void deletePeopleByName(String name);

    void deletePeopleByCode(String code);

    List<PeopleDto> getAllPeople();
}
