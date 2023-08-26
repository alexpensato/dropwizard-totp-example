package com.pensatocode.example.services.otp.exception;

import java.security.NoSuchAlgorithmException;

/**
 * Wraps a {@link NoSuchAlgorithmException} with an unchecked exception.
 */
public class UncheckedNoSuchAlgorithmException extends RuntimeException {

    /**
     * Constructs a new unchecked {@code NoSuchAlgorithmException} instance.
     *
     * @param cause the underlying {@code NoSuchAlgorithmException}
     */
    public UncheckedNoSuchAlgorithmException(final NoSuchAlgorithmException cause) {
        super(cause);
    }

    /**
     * Returns the underlying {@link NoSuchAlgorithmException} that caused this exception.
     *
     * @return the underlying {@link NoSuchAlgorithmException} that caused this exception
     */
    @Override
    public NoSuchAlgorithmException getCause() {
        return (NoSuchAlgorithmException) super.getCause();
    }
}
