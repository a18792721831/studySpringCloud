package com.study.servicesubscriber.dao.mybatis;

import com.study.servicedomain.beans.People;
import com.study.servicedomain.neum.Sex;
import com.study.servicedomain.neum.Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-04-03
 */
@Repository
@Mapper
public interface IMybatisDao {

    @Select(value = "SELECT P.ID, P.AGE, P.CODE, P.HOBBY, P.NAME, P.SEX, P.STATUS " +
            "FROM PEOPLE P " +
            "WHERE P.NAME = #{name, jdbcType=VARCHAR}")
    @Results(value = {@Result(column = "SEX", property = "sex", jdbcType = JdbcType.INTEGER,
            javaType = Sex.class, typeHandler = EnumOrdinalTypeHandler.class),
            @Result(column = "STATUS", property = "status", jdbcType = JdbcType.INTEGER,
                    javaType = Status.class, typeHandler = EnumOrdinalTypeHandler.class)})
    List<People> findPeopleByName(String name);

}
