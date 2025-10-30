package com.pam.asta.exceptions;

public class ApprentiNonTrouveException extends IllegalStateException {
    public ApprentiNonTrouveException(String message, Throwable cause) {
        super(message, cause);
    }
    public ApprentiNonTrouveException(String messageErreur) {
        super(messageErreur);
    }
}
