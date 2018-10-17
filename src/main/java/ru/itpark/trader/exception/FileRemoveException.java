package ru.itpark.trader.exception;

public class FileRemoveException extends RuntimeException {
    public FileRemoveException() {
    }

    public FileRemoveException(String message) {
        super(message);
    }

    public FileRemoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileRemoveException(Throwable cause) {
        super(cause);
    }

    public FileRemoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
