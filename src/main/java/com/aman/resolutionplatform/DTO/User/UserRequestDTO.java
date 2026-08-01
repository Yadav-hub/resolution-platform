package com.aman.resolutionplatform.DTO.User;

import com.aman.resolutionplatform.Enum.User.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min= 3 ,max= 50, message = "Name characheter should be greater than 3 and less than 50")
    private String name;

    @Email(message = "Must be in email format")
    @NotBlank(message = "Email can't be null")
    private String userEmail;

    @Size(min = 10, message = "Phone number should be 10 charachters")
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number format is wrong")
    private String phoneNumber;

    @NotNull
    private UserRole userRole;

    @NotBlank(message = "password can't be null")
    @Size(min=8, message = "Password length shpould be greater than or equals to 8")
    private String password;

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


    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return this.password;
    }
}
