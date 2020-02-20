package com.study.springbootswagger.convert;

import com.study.springbootswagger.neum.Grade;

import javax.persistence.AttributeConverter;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
public class StudentConvert implements AttributeConverter<Grade, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Grade attribute) {
        return attribute.getValue();
    }

    @Override
    public Grade convertToEntityAttribute(Integer dbData) {
        return Grade.fromValue(dbData);
    }
}
