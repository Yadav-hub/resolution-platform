package com.aman.resolutionplatform.DTO.User;

import com.aman.resolutionplatform.Enum.User.UserRole;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserUpdateDTO {


    
    private String name;

    @Email(message = "Must be in email format")
    private String userEmail;

    @Size(min = 10, message = "Phone number should be 10 charachters")
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number format is wrong")
    private String phoneNumber;

    private UserRole userRole;
    
    private boolean active;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getUserEmail()
    {
        return this.userEmail;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public UserRole getUserRole()
    {
        return this.userRole; 
    }

    public void setUserRole(UserRole userRole)
    {
        this.userRole = userRole;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean getActive()
    {
        return this.active;
    }

}
