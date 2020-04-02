package com.study.servicedomain.convert;

import com.study.servicedomain.neum.Status;

import javax.persistence.AttributeConverter;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
public class StatusConvert implements AttributeConverter<Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        return attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return Status.getFromValue(dbData);
    }
}
