package com.fitnesstracker.userservice.controller;

import com.fitnesstracker.userservice.DTO.RegisterRequest;
import com.fitnesstracker.userservice.DTO.UserResponse;
import com.fitnesstracker.userservice.Service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class usercontroller {

    @Autowired
    private userService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getuserprofile(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserprofile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
}
