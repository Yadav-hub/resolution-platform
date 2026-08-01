package com.aman.resolutionplatform.Controller.User;

import org.springframework.web.bind.annotation.RestController;

import com.aman.resolutionplatform.DTO.User.UserRequestDTO;
import com.aman.resolutionplatform.DTO.User.UserResponseDTO;
import com.aman.resolutionplatform.DTO.User.UserRoleUpdateDTO;
import com.aman.resolutionplatform.DTO.User.UserUpdateDTO;
import com.aman.resolutionplatform.Services.User.UserService;
import com.aman.resolutionplatform.Services.User.UserServiceImplementation.UserServiceImple;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UserController {

    private final UserServiceImple userServiceImple;

    public static final Set<String> allowed_Set_SortBy = Set.of(
        "createdAt",
        "name",
        "active",
        "userRole"
    );

    public UserController(UserServiceImple userServiceImple)
    {
        this.userServiceImple = userServiceImple;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable @Positive Integer userId ) {
        return ResponseEntity.ok(userServiceImple.getUserById(userId));
    }

    @GetMapping("/user")
    public ResponseEntity<Page<UserResponseDTO>> getAllUser(@PositiveOrZero @RequestParam(defaultValue = "0") Integer page, @Positive @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "createdAt") String sortBy , @RequestParam(defaultValue = "DESC") String sortOrder) {

        if(!allowed_Set_SortBy.contains(sortBy))
        {
            throw new IllegalArgumentException("Wrong sorting column");
        }
        
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder),sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        return ResponseEntity.ok(userServiceImple.getAllUser(pageable));
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDTO> createUser (@RequestBody @Valid UserRequestDTO user) {
        
        return ResponseEntity.status(201).body(userServiceImple.createUser(user));
    }

    @PutMapping("users/{userId}/{userRole}")
    public ResponseEntity<UserResponseDTO> changeUserRole(@PathVariable @Positive Integer userId, @PathVariable @Valid UserRoleUpdateDTO userRole) 
    {
        return ResponseEntity.ok(userServiceImple.changeUserRole(userId,userRole));
    }

    @PatchMapping("user/{userId}")
    public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable @Positive Integer userId, @RequestBody @Valid UserUpdateDTO userUpdate) {
        
        return ResponseEntity.ok(userServiceImple.updateUserById(userId, userUpdate));
    }
    
    @DeleteMapping("user/{userId}")
    public ResponseEntity<UserResponseDTO> deleteUserById(@PathVariable @Positive Integer userId)
    {
        return ResponseEntity.ok(userServiceImple.deleteUserById(userId));
    }

    

}
