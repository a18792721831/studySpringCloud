package com.study.springbootjpa.convert;

import com.study.springbootjpa.neum.Status;

import javax.persistence.AttributeConverter;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
public class StatusConvert implements AttributeConverter<Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        return attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return Status.fromValue(dbData);
    }
}
