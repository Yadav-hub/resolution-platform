package com.aman.resolutionplatform.DTO.User;

import com.aman.resolutionplatform.Enum.User.UserRole;

public class UserResponseDTO {

    private Integer userId;

    private String name;

    private String userEmail;

    private String phoneNumber;

    private UserRole userRole;
    
    private boolean active;

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public Integer getUserId()
    {
        return this.userId;
    }

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
