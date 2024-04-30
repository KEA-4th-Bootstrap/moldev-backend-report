package org.bootstrap.moldev.exception;

import org.bootstrap.moldev.common.error.BaseErrorCode;
import org.bootstrap.moldev.common.error.BaseErrorException;

public class EntityNotFoundException extends BaseErrorException {

    public EntityNotFoundException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}