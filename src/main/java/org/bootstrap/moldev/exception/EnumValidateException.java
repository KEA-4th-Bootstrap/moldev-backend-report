package org.bootstrap.moldev.exception;

import org.bootstrap.moldev.common.error.BaseErrorException;
import org.bootstrap.moldev.common.error.GlobalErrorCode;

public class EnumValidateException extends BaseErrorException {
    public static final BaseErrorException EXCEPTION = new EnumValidateException();

    public EnumValidateException() {
        super(GlobalErrorCode.INVALID_ENUM_CODE);
    }

}