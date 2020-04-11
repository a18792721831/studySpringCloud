package com.study.servicecustomer.service.impl;

import com.study.servicecustomer.dao.mybatis.IMybatisDao;
import com.study.servicecustomer.service.IMybatisPeopleService;
import com.study.servicedomain.beans.dto.PeopleDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-04-03
 */
@Service("mybatisPeopleService")
public class MybatisPeopleServiceImpl implements IMybatisPeopleService {

    @Autowired
    private IMybatisDao mybatisDao;

    @Override
    public List<PeopleDto> findPeopleByName(String name) {
        return mybatisDao.findPeopleByName(name).stream().map(p -> {
            PeopleDto peopleDto = new PeopleDto();
            BeanUtils.copyProperties(p, peopleDto, PeopleDto.class);
            return peopleDto;
        }).collect(Collectors.toList());
    }
}
