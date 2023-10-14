package com.example.demo.controllers;

import com.example.demo.payload.LoginBody;
import com.example.demo.payload.UserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    //create
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto user1 = user;
        user1.setPassword("0000");
        UserDto userDto =  this.userService.createUser(user1);
        return ResponseEntity.ok(userDto);
    }

    //update
    @PostMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,@PathVariable Integer userId){
        UserDto userDto =  this.userService.updateUser(user, userId);
        return ResponseEntity.ok(userDto);
    }
    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    //get
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        UserDto userDto =  this.userService.getUser(userId);
        return ResponseEntity.ok(userDto);
    }

    //getPublicKey
    @GetMapping("/{userId}/public_key")
    public PublicKey getPublicKey(@PathVariable Integer userId){
        UserDto userDto =  this.userService.getUser(userId);
        return userDto.getPublicKey();
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos =  this.userService.getAllUser();
        return ResponseEntity.ok(userDtos);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> userLogin(@RequestBody LoginBody loginBody){
        UserDto apiRes = new UserDto();
        try {
            apiRes =  this.userService.userLogin(loginBody.getEmail(), loginBody.getPassword());
            return ResponseEntity.ok(apiRes);
        } catch (Exception e) {
            return new ResponseEntity<UserDto>(apiRes, HttpStatus.UNAUTHORIZED);
        }
    
    }

}
