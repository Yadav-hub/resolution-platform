package com.aman.resolutionplatform.Services.User.UserServiceImplementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aman.resolutionplatform.DTO.User.UserRequestDTO;
import com.aman.resolutionplatform.DTO.User.UserResponseDTO;
import com.aman.resolutionplatform.DTO.User.UserRoleUpdateDTO;
import com.aman.resolutionplatform.DTO.User.UserUpdateDTO;
import com.aman.resolutionplatform.Exception.EmailAlreadyExistsException;
import com.aman.resolutionplatform.Exception.PhoneNumberAlreadyExistsException;
import com.aman.resolutionplatform.Exception.UserNotFoundException;
import com.aman.resolutionplatform.Model.User.User;
import com.aman.resolutionplatform.Repository.User.UserRepository;
import com.aman.resolutionplatform.mapper.UserMapper;

@Service
public class UserServiceImple {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImple(UserRepository userRepository, UserMapper userMapper)
    {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public UserResponseDTO getUserById(Integer userId)
    {
        User user =  userRepository.findById(userId).orElseThrow(()->
        new UserNotFoundException("User not found"));
        return userMapper.UserResponseMapper(user);
        
    }

    public Page<UserResponseDTO> getAllUser(Pageable pageable)
    {
        return userRepository.findAll(pageable).map(userMapper::UserResponseMapper);
    }

    public UserResponseDTO changeUserRole(Integer userId, UserRoleUpdateDTO role)
    {
        User user = userRepository.findById(userId)
        .orElseThrow(()->
        new UserNotFoundException("User not found with id "+userId));
        
        user.setUserRole(role.getUserRole());
    
        return userMapper.UserResponseMapper(userRepository.save(user));
    }

    public UserResponseDTO createUser(UserRequestDTO user)
    {

        if(userRepository.existsByPhoneNumber(user.getPhoneNumber()))
        {
            throw new PhoneNumberAlreadyExistsException("Phone Number already present with a user");
        }
        if(userRepository.existsByUserEmail(user.getUserEmail()))
        {
            throw new EmailAlreadyExistsException("Email already registered with another user");
        }
       
        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUserEmail(user.getUserEmail());
        newUser.setUserRole(user.getUserRole());
        
        return userMapper.UserResponseMapper(userRepository.save(newUser));
    }

    public UserResponseDTO updateUserById(Integer userId, UserUpdateDTO userUpdateDTO)
    {

        User user = userRepository.findById(userId)
        .orElseThrow(()->
        new UserNotFoundException("User not found with id "+userId));

        

        if((userUpdateDTO.getName()!=null) && (!userUpdateDTO.getName().isBlank()))
        {
            user.setName(userUpdateDTO.getName());
        }
        if((userUpdateDTO.getPhoneNumber()!=null) && (!userUpdateDTO.getPhoneNumber().isBlank()))
        {
            user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        }
        if((userUpdateDTO.getUserEmail() !=  null) && (!userUpdateDTO.getUserEmail().isBlank()))
        {
            user.setUserEmail(userUpdateDTO.getUserEmail());
        }
        if(userUpdateDTO.getUserRole()!=null)
        {
            user.setUserRole(userUpdateDTO.getUserRole());
        }


        return userMapper.UserResponseMapper(userRepository.save(user));

    }

    public UserResponseDTO deleteUserById(Integer userId)
    {
        User user = userRepository.findById(userId).orElseThrow(
            ()->
            new UserNotFoundException("User not found with id "+userId));

        user.setActive(false);

        return userMapper.UserResponseMapper(userRepository.save(user));
    }

}
