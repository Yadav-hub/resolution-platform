package com.aman.resolutionplatform.Model.User;
import java.time.LocalDateTime;

import com.aman.resolutionplatform.Enum.User.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String userEmail;
    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;
    
    private boolean active;
    private String password;

    private LocalDateTime createdAt;

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

    @PrePersist
    public void onCreate()
    {
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean getActive()
    {
        return this.active;
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
