package com.fitnesstracker.userservice.Service;

import com.fitnesstracker.userservice.DTO.RegisterRequest;
import com.fitnesstracker.userservice.DTO.UserResponse;
import com.fitnesstracker.userservice.model.User;
import com.fitnesstracker.userservice.repository.userrepo;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userrepo userrepo;

    //register method

    public UserResponse register(@Valid RegisterRequest request) {

        //validation for newly registered people to make sure email is not repeating

        if(userrepo.existsByemail(request.getEmail())){
            throw new RuntimeException("Email already exist");
        }

        // creating user instance for saving data to user that can used later
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        //saving user to database
        User saveduser = userrepo.save(user);

        // retrieve data from db to put that in to user response
        UserResponse userResponse = new UserResponse();
        userResponse.setId(saveduser.getId());
        userResponse.setEmail(saveduser.getEmail());
        userResponse.setPassword(saveduser.getPassword());
        userResponse.setFirstName(saveduser.getFirstName());
        userResponse.setLastName(saveduser.getLastName());
        userResponse.setCreatedAt(saveduser.getCreatedAt());
        userResponse.setUpdatedAt(saveduser.getUpdatedAt());

        return userResponse;
    }

    // method for getting user profile
    public UserResponse getUserprofile(String userId) {
        User user = userrepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;

    }
}
