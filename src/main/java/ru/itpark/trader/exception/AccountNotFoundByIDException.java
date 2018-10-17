package ru.itpark.trader.exception;

public class AccountNotFoundByIDException extends RuntimeException {
    public AccountNotFoundByIDException() {
    }

    public AccountNotFoundByIDException(String message) {
        super(message);
    }

    public AccountNotFoundByIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundByIDException(Throwable cause) {
        super(cause);
    }

    public AccountNotFoundByIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
