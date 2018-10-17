package ru.itpark.trader.exception;

import java.io.IOException;

public class MediaUploadException extends RuntimeException {
    public MediaUploadException() {
    }

    public MediaUploadException(String message) {
        super(message);
    }

    public MediaUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public MediaUploadException(Throwable cause) {
        super(cause);
    }

    public MediaUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
