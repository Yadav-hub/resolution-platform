package com.aman.resolutionplatform.Services.User;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aman.resolutionplatform.DTO.User.UserRequestDTO;
import com.aman.resolutionplatform.DTO.User.UserResponseDTO;
import com.aman.resolutionplatform.DTO.User.UserRoleUpdateDTO;
import com.aman.resolutionplatform.DTO.User.UserUpdateDTO;

public interface UserService {


    UserResponseDTO getUserById(Integer userId);

    Page<UserResponseDTO> getAllUser(Pageable pageable);

    UserResponseDTO changeUserRole(Integer userId, UserRoleUpdateDTO userRoleUpdateDTO);

    UserResponseDTO createUser(UserRequestDTO user);

    UserResponseDTO updateUserById(Integer userId, UserUpdateDTO udpateDTO);

    UserResponseDTO deleteUserById(Integer userId);
}
