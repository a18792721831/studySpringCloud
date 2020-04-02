package com.study.servicesubscriber.service.impl;

import com.study.servicedomain.beans.People;
import com.study.servicedomain.beans.dto.PeopleDto;
import com.study.servicedomain.neum.Status;
import com.study.servicesubscriber.dao.jpa.PeopleDao;
import com.study.servicesubscriber.service.PeopleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Override
    public void addPeople(PeopleDto peopleDto) {
        People people = new People();
        BeanUtils.copyProperties(peopleDto, people, People.class);
        peopleDao.saveAndFlush(people);
    }

    @Override
    public List<PeopleDto> findPeopleByCode(String code) {
        List<People> peopleList = peopleDao.findAllByCodeAndStatus(code, Status.VALID);
        return peopleList.stream().map(people -> {
            PeopleDto peopleDto = new PeopleDto();
            BeanUtils.copyProperties(people, peopleDto, PeopleDto.class);
            return peopleDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PeopleDto> findPeopleByName(String name) {
        List<People> peopleList = peopleDao.findAllByNameAndStatus(name, Status.VALID);
        return peopleList.stream().map(people -> {
            PeopleDto peopleDto = new PeopleDto();
            BeanUtils.copyProperties(people, peopleDto, PeopleDto.class);
            return peopleDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void modifyPeople(PeopleDto peopleDto) {
        People people = new People();
        BeanUtils.copyProperties(peopleDto, people, People.class);
        peopleDao.saveAndFlush(people);
    }

    @Override
    public void modifyPeopleNameByCode(String code, String name) {
        peopleDao.saveAll(peopleDao.findAllByCodeAndStatus(code, Status.VALID).stream().map(p -> {
            p.setName(name);
            return p;
        }).collect(Collectors.toList()));
    }

    @Override
    public void deletePeopleByName(String name) {
        peopleDao.saveAll(
                peopleDao.findAllByNameAndStatus(name, Status.VALID).stream().map(p -> {
            p.setStatus(Status.INVALID);
            return p;
        }).collect(Collectors.toList()));
    }

    @Override
    public void deletePeopleByCode(String code) {
        peopleDao.saveAll(
                peopleDao.findAllByCodeAndStatus(code, Status.VALID).stream().map(p -> {
            p.setStatus(Status.INVALID);
            return p;
        }).collect(Collectors.toList()));
    }

    @Override
    public List<PeopleDto> getAllPeople() {
        return peopleDao.findAllByStatus(Status.VALID).stream().map(p -> {
            PeopleDto peopleDto = new PeopleDto();
            BeanUtils.copyProperties(p, peopleDto, PeopleDto.class);
            return peopleDto;
        }).collect(Collectors.toList());
    }
}
