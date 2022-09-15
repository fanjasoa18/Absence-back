package com.example.absencespring.controller;

import com.example.absencespring.model.Users;
import com.example.absencespring.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
public class UsersController {
    private UsersService userService;

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<Users> getUserById(@PathVariable Integer userId){
        return userService.getById(userId);
    }


    @PostMapping("/users")
    public List<Users> saveUsers(@RequestBody List<Users> users){
        return userService.saveAll(users);
    }
}
