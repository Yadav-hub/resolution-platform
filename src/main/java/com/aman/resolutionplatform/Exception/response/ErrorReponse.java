package com.aman.resolutionplatform.Exception.response;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
public class ErrorReponse {

    private LocalDateTime timestamp;
    private String path;
    private String message;
    private HttpStatus statusCode;


    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp()
    {
        return this.timestamp;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
    
    public String getPath()
    {
        return this.path;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setStatusCode(HttpStatus statusCode)
    {
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode()
    {
        return this.statusCode;
    }

}
