package com.study.servicedomain.convert;

import com.study.servicedomain.neum.Sex;

import javax.persistence.AttributeConverter;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
public class SexConvert implements AttributeConverter<Sex, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Sex attribute) {
        return attribute.getValue();
    }

    @Override
    public Sex convertToEntityAttribute(Integer dbData) {
        return Sex.getSexByValue(dbData);
    }
}
