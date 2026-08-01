package com.aman.resolutionplatform.Exception;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message)
    {
        super(message);
    }

}
