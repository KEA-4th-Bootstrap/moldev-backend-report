package org.bootstrap.moldev.entity.converter;

import jakarta.persistence.AttributeConverter;
import org.bootstrap.moldev.entity.ReasonType;
import org.bootstrap.moldev.util.EnumCodeAttributeConverter;

public class ReasonTypeConverter extends EnumCodeAttributeConverter<ReasonType> {

    public ReasonTypeConverter() {
        super(ReasonType.class);
    }
}
