package com.aman.resolutionplatform.Exception;

public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException(String message)
    {
        super(message);
    }
}
