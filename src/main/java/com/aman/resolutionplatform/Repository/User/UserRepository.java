package com.aman.resolutionplatform.Repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aman.resolutionplatform.Model.User.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByUserEmail(String email);

}
