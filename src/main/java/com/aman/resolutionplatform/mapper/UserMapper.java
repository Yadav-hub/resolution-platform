package com.aman.resolutionplatform.mapper;

import org.springframework.stereotype.Component;

import com.aman.resolutionplatform.DTO.User.UserResponseDTO;
import com.aman.resolutionplatform.Model.User.User;

@Component
public class UserMapper {

    
    public UserResponseDTO UserResponseMapper(User user)
    {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setPhoneNumber(user.getPhoneNumber());
       
        userResponseDTO.setActive(user.getActive());
        // System.out.println(userResponseDTO.getActive());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserRole(user.getUserRole());
        
        return userResponseDTO;
    }

}
