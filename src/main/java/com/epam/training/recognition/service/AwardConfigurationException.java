package com.epam.training.recognition.service;

/**
 * Created by Viachaslau_Kavaliou on 11/02/2018.
 */
public class AwardConfigurationException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public AwardConfigurationException(String message) {
        super(message);
    }
}
