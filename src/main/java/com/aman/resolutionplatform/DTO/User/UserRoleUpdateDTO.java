package com.aman.resolutionplatform.DTO.User;

import com.aman.resolutionplatform.Enum.User.UserRole;
import jakarta.validation.constraints.NotNull;

public class UserRoleUpdateDTO {

    @NotNull(message = "Role can't be null")
    private UserRole userRole;
    
    public UserRole getUserRole()
    {
        return this.userRole; 
    }

    public void setUserRole(UserRole userRole)
    {
        this.userRole = userRole;
    }

}
